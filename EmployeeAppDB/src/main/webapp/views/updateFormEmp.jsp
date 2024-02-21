<%@page language="java" %>
<%@page import="com.example.EmployeeAppDB.entity.Employee"%>
<html>
<center>
  <%
        Employee employee = (Employee) request.getAttribute("emp");

        if (employee != null) {
    %>
           <h5>Edit Details for employe id: ${employe.employeId}</h5>
           <form action="/updateResult" >
                <input type="hidden"  name="employeId" value=${emp.employeId}><br>

               <label for="employeName">Enter Employe name : </label>
                <input type="text"  name="employeName" required><br>

               <label for="employeAge">Enter Employe Age : </label>
              <input type="text"  name="employeAge" required><br>

              <label for="employeRole">Enter EmployeRole: </label>

                 <input type="text"  name="employeRole" required><br>
                <input type="submit" value="Submit">
            </form>

    <%
        } else {
    %>
            <h1>No employee details found</h1>
    <%
        }
    %>
     <br><br>
<h3><a href="viewEmploys">View Employees</a></h3>
       <h3> <a href="home">Home</a></h3></center>
</html>