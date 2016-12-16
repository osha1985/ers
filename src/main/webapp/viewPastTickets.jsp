<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Case</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee Reimbursement System</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="#">View Past Tickets</a></li>
            <li><a href="/Project/addReimbursement">Add Reimbursement request</a></li>
        </ul>
    </div>
</nav>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reimbursement" items="${reimbursements}">
            <tr>
                <td>${reimbursement.id}</td>
                <td>${reimbursement.amount}</td>
                <td>${reimbursement.submitted}</td>
                <td>${reimbursement.description}</td>
                <td>${reimbursement.author.username}</td>
                <td>${reimbursement.status.status}</td>
                <td>${reimbursement.type.type}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>