<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.springBootMaps.entity.laptop" %>
<%@ page import="com.example.springBootMaps.entity.student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Laptop Details</title>
</head>
<body>
<center>
    <h1>Laptop Details</h1>
    <table border="1">
        <tr>
            <th>Laptop ID</th>
            <th>Brand</th>
            <th>Cost</th>
            <th>Student Id</th>
        </tr>
        <%
            List<laptop> laptops = (List<laptop>) request.getAttribute("list");
            if (laptops != null) {
                for (laptop laptop : laptops) {
                      student student = laptop.getStudent();

        %>
        <tr>
            <td><%= laptop.getLapId() %></td>
            <td><%= laptop.getBrand() %></td>
            <td><%= laptop.getCost() %></td>
            <td><%= student != null ? student.getId() : "N/A" %></td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No laptops found</td>
        </tr>
        <% } %>
    </table>
        <a href="viewDetails" class="nav-link">Back</a>

    </center>
</body>
</html>
