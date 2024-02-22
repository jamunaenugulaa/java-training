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
        <form action="searchResult">
            <label for="id">Student ID:</label><br>
            <input type="text" id="id" name="id"><br>
                    <input type="submit" value="Submit">
                </form>

        <%
               student student = (student) request.getAttribute("s");
            if (student!=null) {
            laptop lap=student.getLap();
        %>
            <h2>Student Details</h2>
              <table>
            <tr>
                <th>Student Name</th>
                <td>${s.name}</td>
            </tr>
            <tr>
                <th>Student Id</th>
                <td>${s.id}</td>
            </tr>
            <tr>
                <th>Student Age</th>
                <td>${s.age}</td>
            </tr>
            <tr>
              <th>Lap Id</th>
               <td><%= lap != null ? lap.getLapId() : "N/A" %></td>
              </tr>
              <tr>
                <th>Lap Brand</th>
                <td><%= lap != null ? lap.getBrand() : "N/A" %></td>
                 </tr>
     <tr>
                   <th>Lap Cost</th>
                    <td><%= lap != null ? lap.getCost() : "N/A" %></td>
                   </tr>


        </table>
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
