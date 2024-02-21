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
        <%
                Employee employe = (Employee) request.getAttribute("employee");
            if (employe!=null) {
        %>
            <h2>Employee Details Successfully Added</h2>
              <table>
            <tr>
                <th>Employee Name</th>
                <td>${employee.employeName}</td>
            </tr>
            <tr>
                <th>Employee Id</th>
                <td>${employee.employeId}</td>
            </tr>
            <tr>
                <th>Employee Age</th>
                <td>${employee.employeAge}</td>
            </tr>
            <tr>
                <th>Employee Role</th>
                <td>${employee.employeRole}</td>
            </tr>
        </table>
            <br>

        <% } else { %>
            <h2>The Employee Id already exists.<br>Cannot create a new Employee.</h2>
            <form action="/addEmployee" >
            <label for="employeId">Enter Id : </label>
                 <input type="number"  name="employeId" required><br>

                <label for="employeName">Enter Employe name : </label>
                 <input type="text"  name="employeName" required><br>
                 <label for="employeAge">Enter Employe Age: </label>
                      <input type="text"  name="employeAge" required><br>

                  <label for="employeRole">Enter EmployeRole: </label>
                     <input type="text"  name="employeRole" required><br>
                 <input type="submit" value="Submit">
                 </form>
                 <br><br>
        <% } %>
        <br>
        <h3><a href="viewEmploys">View Employees</a></h3>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
