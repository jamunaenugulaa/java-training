<%@page language="java" %>
<%@page import="com.example.EmployeeAppDB.entity.Employee"%>

<html>
<center>
<h2>Get Employe Details By Entering Employe Id</h2>
<form action="/searchResults" >
    <label for="employeId">Enter Id : </label>
     <input type="text" a name="employeId" required><br><br>
     <input value="Submit" type="Submit">
  </form>
  <br>
     <h3> <a href="home">Home</a></h3>
  </center>
  </html>

