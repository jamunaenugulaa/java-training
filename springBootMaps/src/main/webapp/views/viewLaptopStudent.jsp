<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.springBootMaps.entity.laptop" %>
<%@ page import="com.example.springBootMaps.entity.student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student and Laptop Details</title>
</head>
<body>
<center>
    <h1>Student and Laptop Details</h1>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Student Age</th>
            <th>Laptop ID</th>
            <th>Laptop Brand</th>
            <th>Laptop Cost</th>
        </tr>
        <%
            List<laptop> laptops = (List<laptop>) request.getAttribute("list");
            if (laptops != null ) {
                for (laptop laptop : laptops) {
                    student student = laptop.getStudent(); // Assuming a method like this exists
        %>
        <tr>
         <td>
         <%= student.getId() %></td>
          <td><%= student.getName() %></td>
           <td><%= student.getAge() %></td>
            <td><%= laptop.getLapId() %></td>
            <td><%= laptop.getBrand() %></td>
            <td><%= laptop.getCost() %></td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">No student and laptop details found</td>
        </tr>
        <% } %>
    </table>
                <a href="viewDetails" class="nav-link">Back</a>

    </center>
</body>
</html>
