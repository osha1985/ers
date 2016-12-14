<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle" type="button"
                data-toggle="dropdown">
            Filter Reimbursements <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">All</a></li>
            <li><a href="#">Pending</a></li>
            <li><a href="#">Approved</a></li>
            <li><a href="#">Denied</a></li>
        </ul>
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
            <th>Receipt</th>
            <th>Author</th>
            <th>Status</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>14.5</td>
            <td>09-DEC-16 04.39 AM</td>
            <td>Expensive soap</td>
            <td>Receipt image</td>
            <td>Johnny Mnemonic</td>
            <td>Pending</td>
            <td>Other</td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>