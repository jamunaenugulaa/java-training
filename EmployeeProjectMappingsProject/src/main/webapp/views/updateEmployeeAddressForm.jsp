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

   <form:form action="updateEmployeeAddresssDone" modelAttribute="addressModel" >
          <label for="addressId">Enter Address ID:</label><br>
          <input type="number" name="addressId" /><br>
          <form:errors path="addressId" style="color: red;" /><br>

          <label for="pincode">PinCode:</label><br>
          <input type="number" name="pincode" /><br>
          <form:errors path="pincode" style="color: red;" /><br>

          <label for="city">City:</label><br>
          <input name="city" /><br>
          <form:errors path="city" style="color: red;" /><br>

          <input type="submit" value="Update Address">
      </form:form>
</center>
</body>
</html>
