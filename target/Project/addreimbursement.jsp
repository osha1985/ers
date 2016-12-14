<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
            <li><a href="#">Add Reimbursement request</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>Please enter the fields specified to submit your request</h2>
    <form>
        <div class="form-group">
            <label for="amount">Reimbursement amount:</label> <input
                type="number" class="form-control" id="amount"
                placeholder="Reimbursement amount">
        </div>
        <div class="form-group">
            <label for="descr">Description:</label>
            <textarea rows="5" type="text" class="form-control" id="descr"
                      placeholder="Enter description"></textarea>
        </div>
        <div class="form-group">
            <label for="receipt">Receipt:</label> <input type="file" id="receipt">
        </div>
        <div class="form-group">
            <label for="sel1">Reimbursement type:</label>
            <select class="form-control" id="sel1">
                <option>LODGING</option>
                <option>TRAVEL</option>
                <option>FOOD</option>
                <option>OTHER</option>
            </select>
        </div>
        <div class="checkbox">
            <label><input type="checkbox"> Remember me</label>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>