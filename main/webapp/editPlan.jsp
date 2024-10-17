<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.RechargePlan" %>
<%@ page import="dao.DB_Operations" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    DB_Operations dbOperations = new DB_Operations();
    RechargePlan plan = dbOperations.getRechargePlanById(id);

    if (plan == null) {
        out.println("<p class='text-danger'>Recharge plan not found.</p>");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Recharge Plan</title>
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
        <h2 class="text-center mt-5">Edit Recharge Plan</h2>
        
        <form action="updatePlan" method="post" class="mt-4">
            <input type="hidden" name="id" value="<%= plan.getId() %>">
            <div class="form-group">
                <label for="planName">Plan Name:</label>
                <input type="text" name="planName" class="form-control" value="<%= plan.getPlanName() %>" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" step="0.01" name="price" class="form-control" value="<%= plan.getPrice() %>" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea name="description" class="form-control" rows="4" required><%= plan.getPlanDescription() %></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Update Recharge Plan</button>
        </form>
        <a href="adminDashboard.jsp" class="btn btn-secondary btn-block mt-3">Back to Dashboard</a>
    </div>

   
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
