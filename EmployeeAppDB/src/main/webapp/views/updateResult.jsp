<%@page language="java" %>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <center>
                <h2>Employee Details Updated Successfully</h2>
                <table border="1">
                    <tr>
                        <th>Employee Name</th>
                        <th>Employee Id</th>
                        <th>Employee Role</th>
                    </tr>
                    <tr>
                        <td>${employe.employeName}</td>
                        <td>${employe.employeId}</td>
                        <td>${employe.employeRole}</td>
                    </tr>
                </table>


<h3><a href="viewEmploys">View Employees</a></h3>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
