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
    <h2>Admin Registration</h2>

    <form:form action="registerEmployee" modelAttribute="adminModel">
        <label for="Id">ID:</label>
        <form:input type="number" path="Id"/><br>


        <label for="Name">Name:</label>
        <form:input path="Name" /><br>
        <form:errors path="Name" style="color: red;"/><br>
        <label for="Mail">Email:</label>
        <form:input  path="Mail" /><br>
          <form:errors path="Mail"  style="color: red;"/><br>
        <label for="Role">Role:</label>
        <form:input  path="Role" /><br>
        <form:errors path="Role" style="color: red;"/><br>

        <input type="submit" value="Register">
    </form:form>
</center>
</body>
</html>
