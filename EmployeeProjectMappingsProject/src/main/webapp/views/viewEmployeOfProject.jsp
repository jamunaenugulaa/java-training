<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.EmployeeProjectMapping.Entity.Address" %>

<%@ page import="com.example.EmployeeProjectMapping.Model.EmployeeModel" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Details</title>
     <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
</head>
<body>
    <h1>Employee Details</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Address ID</th>
            <th>Pincode</th>
            <th>City</th>
            <th>DeleteEmployee</th>

        </tr>
        <%
            List<EmployeeModel> employeeList = (List<EmployeeModel>) request.getAttribute("employeeList");
            if(employeeList != null) {
                for(EmployeeModel employee : employeeList) {
        %>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getGmail() %></td>
            <td><%= employee.getRole() %></td>
            <td><%= employee.getAddress().getAddressId() %></td>
            <td><%= employee.getAddress().getPincode() %></td>
            <td><%= employee.getAddress().getCity() %></td>
            <td><form action="DeleteEmployeOfProject"><input type="hidden" name="eid" value="<%= employee.getId() %>" readonly>
            <input type="hidden" name="pid" value="${pid}" readonly>

            <input type="submit" value="Delete Employee"> </form></td>

        </tr>
        <%
                }
            }
        %>
    </table>
<center><h2><a href="adminView">Back</a></h2><center>

</body>
</html>
