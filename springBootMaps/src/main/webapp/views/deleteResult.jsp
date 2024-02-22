<%@ page language="java" %>
<%@page import="com.example.springBootMaps.entity.student" %>
<%@page import="com.example.springBootMaps.entity.laptop" %>


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
    <h2>Search Here</h2>

        <%
         student student = (student) request.getAttribute("s");
        if (student!=null) {
        %>
            <h2>Student ${s.name} Details Deleted SuccessFully</h2>

            <br>

        <% } else { %>
            <h2>The Student Id not Exists</h2>

                 <br><br>
        <% } %>
        <br>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
