<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.springBootMaps.entity.laptop" %>
<%@ page import="com.example.springBootMaps.entity.student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
<center>
    <h1>Student Details</h1>
    <table border="1">
        <tr>
            <th>StudentID</th>
            <th>StudentName</th>
            <th>StudentAge</th>
            <th>Laptop Id</th>
        </tr>
        <%
            List<student> students = (List<student>) request.getAttribute("list");
            if (students != null) {
                for (student student : students) {
                laptop lap=student.getLap();
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= lap != null ? lap.getLapId() : "N/A" %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No students found</td>
        </tr>
        <% } %>

    </table>
            <a href="viewDetails" class="nav-link">Back</a>

    </center>
</body>
</html>
