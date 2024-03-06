<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.example.EmployeeProjectMapping.Model.ProjectModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project List</title>
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

    <h2>Project List</h2>

    <table>
        <tr>
            <th>Project ID</th>
            <th>Project Name</th>
            <th>Project Guide</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Employees Required</th>
            <th>Duration (months)</th>
             <th>View Employees</th>

            <th>Add Employee</th>
        </tr>
        <%
            List<ProjectModel> projectList = (List<ProjectModel>) request.getAttribute("projectList");
            if (projectList != null) {
                for (ProjectModel project : projectList) {
        %>
        <tr>
            <td><%= project.getProjectId() %></td>
            <td><%= project.getProjectName() %></td>
            <td><%= project.getProjectGuide() %></td>
            <td><%= project.getStartDate() %></td>
            <td><%= project.getEndDate() %></td>
            <td><%= project.getEmployesRequired() %></td>
            <td><%= project.getDuration() %></td>
             <td><form action="viewEmployeOfProject"><input type="hidden" name="pid" value="<%= project.getProjectId() %>" readonly>
                        <input type="submit" value="view Employees"> </form></td>
            <td><form action="assignProjectToEmploye"><input type="hidden" name="pid" value="<%= project.getProjectId() %>" readonly>
            <input type="submit" value="Add Employee">
            </form></td>
        </tr>
        <%      }
            }
        %>
    </table>
<center><h2><a href="adminView">Back</a></h2><center>
</body>
</html>
