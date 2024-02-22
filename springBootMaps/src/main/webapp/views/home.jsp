<%@page language="java" %>
<%@page import="com.example.springBootMaps.controller.studentController" %>
<%@page import="com.example.springBootMaps.controller.laptopController" %>

<html>
<head>
    <style>
        /* Define styles for the navigation links */
        .nav-link {
            text-decoration: none;
            padding: 5px 10px;
            margin-right: 10px;
            color: #333;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        /* Define hover effect for the navigation links */
        .nav-link:hover {
            background-color: #eaeaea;
        }
    </style>
</head>
<body>
<center>
    <a href="addStudent" class="nav-link">Add Student</a>
    <a href="addLaptop" class="nav-link">Add Laptop</a>
    <a href="viewDetails" class="nav-link">View Details</a>
    <a href="searchStudent" class="nav-link">Search Details</a>
    <a href="updateStudent" class="nav-link">Update Student Details</a>
   <a href="deleteStudent" class="nav-link">Delete Student Details</a>
</center>
</body>
</html>
