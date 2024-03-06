<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
    <style>
        label {
            display: inline-block;
            width: 100px;
            margin-bottom: 10px;
        }
        input[type="text"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<center>
    <h2>Update Your Details</h2>

    <form:form action="updateEmployeeDetailsDone" modelAttribute="employeeModel">
        <label for="Id">ID:</label>
        <input type="number" path="Id" value="${eid}" readonly><br>


        <label for="Name">Name:</label>
        <form:input path="name" /><br>
        <form:errors path="name" style="color: red;"/><br>
        <label for="gmail">Email:</label>
        <form:input  path="gmail" /><br>
          <form:errors path="gmail"  style="color: red;"/><br>
        <label for="role">Role:</label>
        <form:input  path="role" /><br>
        <form:errors path="role" style="color: red;"/><br>


        <input type="submit" value="Register">
    </form:form>
</center>
</body>
</html>
