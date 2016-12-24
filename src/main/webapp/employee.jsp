<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Case</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Employee Reimbursement System</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="http://localhost:7001/Project/viewPastTickets">View Past Tickets</a></li>
            <li><a href="http://localhost:7001/Project/addReimbursement">Add Reimbursement request</a></li>
            <li><a href="http://localhost:7001/Project/logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h3>Welcome to the Employee Reimbursement System</h3>
    <h4>Please select an option at the top</h4>
</div>

</body>
</html>