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

        <%
          Student students = (Student )request.getAttribute("student");
            if (students != null) {
        %>
    <h2>Student Details Successfully Deleted</h2>
              <table>
            <tr>
                <th>Student Name</th>
                <td>${student.name}</td>
            </tr>
            <tr>
                <th>Student Id</th>
                <td>${student.id}</td>
            </tr>
            <tr>
                <th>Student Age</th>
                <td>${student.age}</td>
            </tr>

        </table>
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
