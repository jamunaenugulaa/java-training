<%@page import="com.example.springBootMaps.controller.laptopController" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Laptop</title>
</head>
<body>
<center>
    <h2>Add Laptop</h2>
    <form action="addResLap">
        <label for="lapId">Laptop Number:</label><br>
        <input type="number" id="lapId" name="lapId" required><br>

        <label for="brand">Laptop Company:</label><br>
        <input type="text" id="brand" name="brand" required><br>

        <label for="cost">Enter Price:</label><br>
        <input type="text" id="cost" name="cost" required><br><br>

         <label for="student">Student Id to Assign:</label><br>
          <input type="text" id="student" name="student" required><br><br>


        <input type="submit" value="Submit">
    </form>
           <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
