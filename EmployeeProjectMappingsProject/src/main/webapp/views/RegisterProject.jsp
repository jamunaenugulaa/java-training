<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Project</title>
    <style>
        label {
            display: inline-block;
            width: 150px;
            margin-bottom: 10px;
        }
        input[type="text"], input[type="date"], input[type="number"] {
            width: 200px;
            padding: 5px;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<center>

    <h2>Register Project</h2>

    <form action="RegisterProjectDone">
        <label for="projectId">Project ID:</label>
        <input type="number" id="projectId" name="projectId" required><br>

        <label for="projectName">Project Name:</label>
        <input type="text" id="projectName" name="projectName" required><br>

        <label for="projectGuide">Project Guide:</label>
        <input type="text" id="projectGuide" name="projectGuide" required><br>

         <label for="employesRequired">Employees Required:</label>
          <input type="text" id="employesRequired" name="employesRequired" required><br>


        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required><br>

        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required><br>


        <label for="duration">Duration (in months):</label>
        <input type="number" id="duration" name="duration" required><br>
             <label for="Id">Admin ID:</label>


          <input type="number" id="admin" name="admin" value="${id}" readonly><br>


        <input type="submit" value="Register">
    </form>
</center>
</body>
</html>
