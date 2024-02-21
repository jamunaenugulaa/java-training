<%@ page language="java" %>
<%@page import="com.example.EmployeeAppDB.entity.Employee"%>

<html>
<head>
    <title>Employee Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <center>

  <br>

        <% Employee employee = (Employee) request.getAttribute("emp"); %>
        <% if (employee!= null) { %>
           <h2>Employe Deleted Successfully</h2>
        <% } else { %>
        <h2>Get  Enter Employe Id to Delete</h2>
        <form action="/deleteResult" >
            <label for="employeId">Enter Id : </label>
             <input type="text" a name="employeId" required><br><br>
             <input value="Submit" type="Submit">
          </form>

            <h1>No employee details found</h1>
        <% } %>
        <h3><a href="viewEmploys">View Employees</a></h3>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
