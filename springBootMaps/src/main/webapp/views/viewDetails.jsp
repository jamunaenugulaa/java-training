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
    <a href="studentDetails" class="nav-link">View Student Details</a>
    <a href="laptopDetails" class="nav-link">View Laptop Details</a>
    <a href="viewLaptopStudent" class="nav-link">View Laptop-Student Details</a>
           <h3> <a href="home">Home</a></h3>


</center>
</body>
</html>
