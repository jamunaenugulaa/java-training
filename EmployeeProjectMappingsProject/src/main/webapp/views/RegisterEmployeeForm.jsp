<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Employee</title>
    <style>
        label {
            display: inline-block;
            width: 150px;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="password"], input[type="email"], input[type="number"] {
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
    <h2>Register Employee</h2>

    <form action="RegisterEmployeeDone">
     <label for="id">Employee Id:</label>
       <input type="number" id="id" name="id" required><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="gmail">Email:</label>
        <input type="email" id="gmail" name="gmail" required><br>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" required><br>

          <label for="username">Username:</label>
         <input type="text" id="username" name="username" required><br>


         <label for="password">Password:</label>
         <input type="password" id="password" name="password" required><br>




        <label for="addressId">Address ID:</label>
        <input type="number" id="addressId" name="addressId" required><br>

        <label for="pincode">Pincode:</label>
        <input type="number" id="pincode" name="pincode" required><br>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>


        <input type="submit" value="Register">
    </form>
</center>
</body>
</html>
