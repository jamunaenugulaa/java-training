<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.MappingOneToManyDemo.Entity.Courses" %>
<%@ page import="com.example.MappingOneToManyDemo.Entity.Student" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
<center>

         <%
                  Courses s = (Courses) request.getAttribute("course");
                   if (s!=null) {
               %>
                   <h2>Course Details Successfully Deleted</h2>
                     <table>
                   <tr>
                       <th>Course Name</th>
                       <td>${course.courseName}</td>
                   </tr>
                   <tr>
                       <th>Course Id</th>
                       <td>${course.courseId}</td>
                   </tr>
                   <tr>
                       <th>SCourse Guide</th>
                       <td>${course.courseGuide}</td>
                   </tr>


               </table>
                   <br>

               <% } else { %>
                   <h2>Course is Not Found</h2>

                        <br><br>
               <% } %>

    </table>
       <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
