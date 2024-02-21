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
<h2>Get Employe Details By Entering Employe Id</h2>
<form action="/searchResults" >
    <label for="employeId">Enter Id : </label>
     <input type="text" a name="employeId" required><br><br>
     <input value="Submit" type="Submit">
  </form>
  <br>

        <% Employee employee = (Employee) request.getAttribute("emp"); %>
        <% if (employee!= null) { %>
            <h1>Employee Details</h1>
             <table>
                        <tr>
                            <th>Employee Name</th>
                            <td>${emp.employeName}</td>
                        </tr>
                        <tr>
                            <th>Employee Id</th>
                            <td>${emp.employeId}</td>
                        </tr>
                        <tr>
                            <th>Employee Age</th>
                            <td>${emp.employeAge}</td>
                        </tr>
                        <tr>
                            <th>Employee Role</th>
                            <td>${emp.employeRole}</td>
                        </tr>
                    </table><br><br>
        <% } else { %>
            <h1>No employee details found</h1>
        <% } %>
        <h3><a href="viewEmploys">View Employees</a></h3>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
