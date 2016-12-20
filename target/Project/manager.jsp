<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#filterMenu").change(function () {
                switch ($(this).val()) {
                    case "All": {
                        $("tr").show();
                        break;
                    }
                    <c:forEach var="status" items="${reimbursementStatus}">
                    case "${status.status}": {
                        $("tr").hide();
                        $(".${status.status}").show();
                        break;
                    }
                    </c:forEach>
                }
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee Reimbursement System</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/Project/">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="form-group">
        <label for="sel1">Filter Reimbursements:</label>
        <select id="filterMenu" class="form-control" id="sel1">
            <option value="All">All</option>
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
            <th>Receipt</th>
            <th>Change status</th>
            <th>Submit changes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reimbursement" items="${reimbursements}">
            <form id="reimbursementForm" action="manager" method="post">
                <tr class="${reimbursement.status.status}">
                    <td>${reimbursement.id}</td>
                    <td>${reimbursement.amount}</td>
                    <td>${reimbursement.submitted}</td>
                    <td>${reimbursement.description}</td>
                    <td>${reimbursement.author.firstName.concat(" ").concat(reimbursement.author.lastName)}</td>
                    <td>${reimbursement.status.status}</td>
                    <td>${reimbursement.type.type}</td>
                    <td><img src="data:image/png;base64,${reimbursement.receipt}" alt=""></td>
                    <td><select class="form-control" name="reimbursementStatusId">
                        <c:forEach var="status" items="${reimbursementStatus}">
                            <option value="${status.statusId}">${status.status}</option>
                        </c:forEach>
                    </select></td>
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