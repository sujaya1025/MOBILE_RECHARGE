<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #ccc3af;
        }
        .container {
            margin-top: 50px;
            max-width: 400px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Register</h2>
        <form action="register" method="post" onsubmit="return validatePassword()">
            <div class="form-group">
                <label>Username:</label>
                <input type="text" name="username" class="form-control" required>
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" id="password" class="form-control" required>
                <small id="passwordHelp" class="form-text text-muted">Password must contain at least 1 uppercase, 1 lowercase, 1 number, 1 special character, and must be 4 to 12 characters long.</small>
            </div>
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success btn-block">Register</button>
        </form>

        <c:if test="${not empty param.error}">
            <div class="alert alert-danger mt-3">${param.error}</div>
        </c:if>
    </div>

    
    <script>
        function validatePassword() {
            var password = document.getElementById("password").value;
            var passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&]).{4,12}$/;

            if (!passwordPattern.test(password)) {
                alert("Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number, 1 special character, and must be 4 to 12 characters long.");
                return false;
            }
            return true;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
