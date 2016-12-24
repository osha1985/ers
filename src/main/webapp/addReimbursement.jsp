<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Case</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.1/additional-methods.min.js"></script>
    <script src="scripts/addReimbursement.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee Reimbursement System</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:7001/Project/viewPastTickets">View Past Tickets</a></li>
            <li><a href="#">Add Reimbursement request</a></li>
            <li><a href="http://localhost:7001/Project/logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>Please enter the fields specified to submit your request</h2>
    <form action="reimbursementAdded" method="post" id="reimbursementForm">
        <div class="form-group">
            <label for="amount">Reimbursement amount:</label>
            <div class="input-group">
                <span class="input-group-addon">$</span>
                <input type="number" class="form-control" id="amount"
                       placeholder="Reimbursement amount" name="reimbursementAmount" step="0.01" required>
            </div>

        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea rows="5" type="text" class="form-control" id="description"
                      placeholder="Enter description" name="reimbursementDescription" required></textarea>
        </div>
        <div class="form-group">
            <label for="receipt">Receipt:</label><input type="file" id="receipt" accept='image/*' required>
        </div>
        <div class="form-group">
            <label for="sel1">Reimbursement type:</label>
            <select class="form-control" id="sel1" name="reimbursementType">
                <c:forEach var="reimbursementType" items="${reimbursementTypes}">
                    <option value="${reimbursementType.typeId}">${reimbursementType.type}</option>
                </c:forEach>
            </select>
        </div>
        <input id="receiptStore" type="hidden" name="reimbursementReceipt">
        <div class="checkbox">
            <label><input type="checkbox"> Remember me</label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

</div>

</body>
</html>