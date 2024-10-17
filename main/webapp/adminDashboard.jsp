<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Operator" %>
<%@ page import="model.RechargePlan" %>
<%@ page import="dao.DB_Operations" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        h2 {
            margin-top: 40px;
        }
        .action-links a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h1>Admin Dashboard</h1>
    <a href="logout">Logout</a>

    <h2>Manage Operators</h2>
    <table>
        <tr>
            <th>Operator Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <%
            DB_Operations dbOperations = new DB_Operations();
            List<Operator> operators = dbOperations.getAllOperators();
            if (operators != null) {
                for (Operator operator : operators) {
        %>
        <tr>
            <td><%= operator.getName() %></td>
            <td><%= operator.getDescription() %></td>
            <td class="action-links">
                <a href="editOperator.jsp?id=<%= operator.getId() %>">Edit</a> |
                <a href="deleteOperator?id=<%= operator.getId() %>" onclick="return confirm('Are you sure you want to delete this operator?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No operators found.</td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="addOperator.jsp">Add Operator</a>

    <h2>Manage Recharge Plans</h2>
    <table>
        <tr>
            <th>Plan Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <%
            List<RechargePlan> plans = dbOperations.getAllRechargePlans(); // Fetch all recharge plans
            if (plans != null) {
                for (RechargePlan plan : plans) {
        %>
        <tr>
            <td><%= plan.getPlanName() %></td>
            <td><%= plan.getPrice() %></td>
            <td><%= plan.getPlanDescription() %></td>
            <td class="action-links">
                <a href="editPlan.jsp?id=<%= plan.getId() %>">Edit</a> |
                <a href="deletePlan?id=<%= plan.getId() %>" onclick="return confirm('Are you sure you want to delete this plan?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No recharge plans found.</td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="addPlan.jsp">Add Recharge Plan</a>
</body>
</html>
