<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Recharge Plan</title>
    
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
     <style>
 
        .container {
            margin-top: 50px;
            max-width: 400px;
        }
    </style>
</head>
<body class="bg-light">

    <div class="container">
        <h2 class="text-center">Add Recharge Plan</h2>

        <form action="addPlan" method="post" class="mt-4">
            <div class="form-group">
                <label for="id">Recharge Plan ID:</label>
                <input type="number" id="id" name="id" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="operatorId">Operator ID:</label>
                <input type="number" id="operatorId" name="operatorId" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="planName">Plan Name:</label>
                <input type="text" id="planName" name="planName" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" step="0.01" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" class="form-control" required></textarea>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Add Recharge Plan</button>
        </form>

        <a href="adminDashboard.jsp" class="btn btn-secondary btn-block mt-3">Back to Dashboard</a>
    </div>

   
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
