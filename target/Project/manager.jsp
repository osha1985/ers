<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Reimbursement System</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="scripts/manager.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee Reimbursement System</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:7001/Project/logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <label for="filterMenu">Filter Reimbursements:</label>
    <div class="btn-group" id="filterMenu" role="group" aria-label="Filter Reimbursements:">
        <button type="button" class="btn btn-default filter" value="All">All</button>
        <c:forEach var="status" items="${reimbursementStatus}">
            <button type="button" class="btn btn-default filter" value="${status.status}">${status.status}</button>
        </c:forEach>
    </div>
</div>

<div class="container">
    <h2>Reimbursements</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Amount</th>
            <th>Submitted</th>
            <th>Resolved</th>
            <th>Description</th>
            <th>Receipt</th>
            <th>Author</th>
            <th>Resolver</th>
            <th>Status</th>
            <th>Type</th>
            <th>Change status</th>
            <th>Submit changes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reimbursement" items="${reimbursements}">
            <form id="reimbursementForm" action="manager" method="post">
                <tr class="${reimbursement.status.status}">
                    <td>${reimbursement.id}</td>
                    <td class="reimbursementAmount">${reimbursement.amount}</td>
                    <td>${reimbursement.submitted.toLocaleString()}</td>
                    <td>${reimbursement.resolved.toLocaleString()}</td>
                    <td>${reimbursement.description}</td>
                    <td><a download="receipt.png" href="data:image/png;base64,${reimbursement.receipt}"
                           alt="">Download</a></td>
                    <td>${reimbursement.author.firstName.concat(" ").concat(reimbursement.author.lastName)}</td>
                    <td>${reimbursement.resolver.firstName.concat(" ").concat(reimbursement.resolver.lastName)}</td>
                    <td>${reimbursement.status.status}</td>
                    <td>${reimbursement.type.type}</td>
                    <td>
                        <c:forEach var="status" items="${reimbursementStatus}">
                            <div class="radio">
                                <label>
                                    <input class="radioButton" type="radio" name="reimbursementStatusId"
                                           value="${status.statusId}">${status.status}
                                </label>
                            </div>
                        </c:forEach>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </td>
                </tr>
                <input name="reimbursementId" type="hidden" value="${reimbursement.id}">
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>