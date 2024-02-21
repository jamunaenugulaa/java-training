<%@page language="java" %>
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
    <a href="formFilling" class="nav-link">Add New Employee</a>
    <a href="viewEmploys" class="nav-link">View Employees</a>
    <a href="searchEmploye" class="nav-link">Search an Employee</a>
    <a href="updateEmploye" class="nav-link">Update an Employee</a>
    <a href="deleteEmploye" class="nav-link">Delete an Employee</a>
</body>
</html>
