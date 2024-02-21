<%@ page import="java.util.List" %>
<%@page import="com.example.EmployeeAppDB.entity.Employee"%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
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
    <h1>Employee List</h1>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>ID</th>
            <th>Age</th>
            <th>Role</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <%
            List<Employee> employeeList = (List<Employee>) request.getAttribute("empList");
            for (Employee employee : employeeList) {
        %>

            <tr>
                <td><%= employee.getEmployeName()  %></td>
                <td><%= employee.getEmployeId() %></td>
                 <td><%= employee.getEmployeAge() %></td>
                <td><%= employee.getEmployeRole() %></td>
                <td> <form action="updateFormEmp"><input type="hidden"  name="employeId" value="<%= employee.getEmployeId() %>"}>
                <input type="submit" value="Edit"></form></td>
                <td><form action="deleteResult"><input type="hidden"  name="employeId" value="<%= employee.getEmployeId() %>"}>
                  <input type="submit" value="Delete"></form></a></td>
            </tr>
        <% } %>
    </table>
    <br>
<a href="home">Home</a>
</center>
</body>
</html>

