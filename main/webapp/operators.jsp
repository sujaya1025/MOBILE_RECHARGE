<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Operators</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #acd7e2; 
        }
        .card {
            margin: 20px; 
            transition: transform 0.2s; 
        }
        .card:hover {
            transform: scale(1.05); 
        }
        .back-link {
            margin: 20px; 
            font-size: 1.2em; 
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Available Operators</h2>
        <div class="row">
            <c:forEach var="operator" items="${operators}">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${operator.name}</h5>
                            <p class="card-text">${operator.description}</p>
                            <a href="plans?operatorId=${operator.id}" class="btn btn-primary">View Plans</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <a href="index.jsp" class="btn btn-secondary back-link">Back to Home</a>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
