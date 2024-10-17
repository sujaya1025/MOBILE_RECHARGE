<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Operator" %>
<%@ page import="dao.DB_Operations" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    DB_Operations dbOperations = new DB_Operations();
    Operator operator = dbOperations.getOperatorById(id);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Operator</title>
    
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
        <h2 class="text-center mt-5">Edit Operator</h2>
        <form action="updateOperator" method="post" class="mt-4">
            <input type="hidden" name="id" value="<%= operator.getId() %>">
            <div class="form-group">
                <label for="operatorName">Operator Name:</label>
                <input type="text" name="operatorName" class="form-control" value="<%= operator.getName() %>" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea name="description" class="form-control" rows="4" required><%= operator.getDescription() %></textarea>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Update Operator</button>
        </form>
        <a href="adminDashboard.jsp" class="btn btn-secondary btn-block mt-3">Back to Dashboard</a>
    </div>

    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
