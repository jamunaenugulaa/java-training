<%@page language="java" %>

<html>
<center>
<h2>Employe Registration</h2>
<form action="/addEmployee" >
<label for="employeId">Enter Id : </label>
     <input type="number"  name="employeId" required><br>

    <label for="employeName">Enter Employe name : </label>
     <input type="text" pattern="^[A-Za-z]+"  name="employeName" required><br>
     <label for="employeAge">Enter Employe Age: </label>
          <input type="text"  name="employeAge" required><br>

      <label for="employeRole">Enter EmployeRole: </label>
         <input type="text"  name="employeRole" required><br>
     <input type="submit" value="Submit">
     </form>
     <br><br>
     <a href="/home">Home</a>
</center>
</html>