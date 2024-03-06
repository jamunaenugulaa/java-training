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

    <h2>Enter UserName and Password</h2>
    <h3>${msg}</h3>

     <form:form action="updateUsernamePasswordDone" modelAttribute="employeeModel">

            <label for="username">UserName:</label>
            <form:input  path="username" /><br>
              <form:errors path="username"  style="color: red;"/><br>
            <label for="password">Password:</label>
            <form:input  path="password" /><br>
            <form:errors path="password" style="color: red;"/><br>
            <input type="submit" value="Register">
        </form:form>
    </form>
</center>
</body>
</html>
