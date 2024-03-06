<%@page language="java" %>

<html>
<head>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        /* Center the content horizontally */
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        .nav-link {
            text-decoration: none;
            padding: 10px 20px; /* Increase padding for better touch/clickability */
            margin-right: 10px;
            color: #333;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
            transition: background-color 0.3s ease; /* Add smooth transition on hover */
        }

        .nav-link:hover {
            background-color: #eaeaea;
        }
    </style>
</head>
<body>
<div class="container">
    <center>
    <br><br>

        <a href="GetEmployeeDetails" class="nav-link">GET YOUR DETAILS</a><br><br><br>
         <a href="GetProjectsOfEmployee" class="nav-link">GET YOUR PROJECT DETAILS</a><br><br><br>
       <a href="updateEmployeeForm" class="nav-link">UPDATE YOUR DETAILS</a><br><br><br>
           <a href="updateEmployeeAddressForm" class="nav-link">UPDATE YOUR ADDRESS</a><br><br><br>

       <a href="updateUsernameAndPassword" class="nav-link">CHANGE USERNAME AND PASSWORD</a><br><br><br>
           <a href="home" class="nav-link">LOGOUT</a><br>    </center>

    </center>
</div>
</body>
</html>
