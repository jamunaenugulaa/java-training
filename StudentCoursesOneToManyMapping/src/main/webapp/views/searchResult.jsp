<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.MappingOneToManyDemo.Entity.Courses" %>
<%@ page import="com.example.MappingOneToManyDemo.Entity.Student" %>

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
            <th>Courses</th>
        </tr>
        <%
          Student students = (Student )request.getAttribute("student");
            if (students != null) {
        %>
        <tr>
            <td><%= students.getId() %></td>
            <td><%= students.getName() %></td>
            <td><%= students.getAge() %></td>
            <td><form action="/viewCourses">
            <input type="hidden" name="id" value="<%= students.getId() %>" >
            <input type="submit" value="view"></form></td>
        </tr>
        <%

            } else {
        %>
        <tr>
            <td colspan="3">No students found</td>
        </tr>
        <% } %>

    </table>
       <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
