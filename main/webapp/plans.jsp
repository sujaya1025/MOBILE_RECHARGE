<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plans for Operator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #b2a0a0; 
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
        <h2 class="text-center">Recharge Plans</h2>
        <div class="row">
            <c:forEach var="plan" items="${plans}">
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${plan.planName}</h5>
                            <p class="card-text">${plan.planDescription}</p>
                            <p class="card-text"><strong>Price: </strong>${plan.price}</p>
                            <form action="${pageContext.request.contextPath}/RechargeServlet" method="post">
                                <input type="hidden" name="planId" value="${plan.id}"/>
                                <input type="hidden" name="planName" value="${plan.planName}"/>
                                <button type="submit" class="btn btn-success">Recharge Now</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <a href="operators" class="btn btn-secondary back-link">Back to Operators</a>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
