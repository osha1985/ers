<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="script.js"></script>
</head>
<body>

<div class="container">
    <div class="form-group">
        <label for="sel1">Filter Reimbursements:</label>
        <select id="filterMenu" class="form-control" id="sel1">
            <c:forEach var="status" items="${reimbursementStatus}">
                <option value="${status.status}">${status.status}</option>
            </c:forEach>
        </select>
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
            <th>Description</th>
            <th>Author</th>
            <th>Status</th>
            <th>Type</th>
            <th>Change status</th>
            <th>Submit changes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reimbursement" items="${reimbursements}">
            <form id="reimbursementForm" action="manager" method="post">
                <tr class=".${reimbursement.status.status}" ">
                    <td><input name="reimbursementId" type="text" value="${reimbursement.id}"></td>
                    <td><input type="text" value="${reimbursement.amount}"></td>
                    <td><input type="text" value="${reimbursement.submitted}"></td>
                    <td><input type="text" value="${reimbursement.description}"></td>
                    <td><input type="text" value="${reimbursement.author.username}"></td>
                    <td><input type="text" value="${reimbursement.status.status}"></td>
                    <td><input type="text" value="${reimbursement.type.type}"></td>
                    <td><select id="filterMenu" class="form-control" id="sel1" name="reimbursementStatusId">
                        <c:forEach var="status" items="${reimbursementStatus}">
                            <option value="${status.statusId}">${status.status}</option>
                        </c:forEach>
                    </select></td>
                    <td>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>