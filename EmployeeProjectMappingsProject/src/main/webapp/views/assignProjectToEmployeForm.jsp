<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <h2>Enter Employee ID</h2>
    <h3>${msg}</h3>

    <form action="assignProjectToEmployeeDone" >
    <input type="hidden" name="pid" value="${pid}" readonly>
        <label for="id">Employee ID:</label>
        <input type="number" id="id" name="id" required><br>
        <input type="submit" value="submit">
    </form>
</center>
</body>
</html>
