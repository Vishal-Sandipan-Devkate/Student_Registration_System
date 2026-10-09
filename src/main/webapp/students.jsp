<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Registered Students</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 800px;
            margin: 50px auto;
            background-color: white;
            padding: 25px;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #cccccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #eeeeee;
        }

        .button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #333333;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Registered Students</h2>

    <table>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Action</th>
        </tr>

        <c:forEach var="student"
                   items="${students}">

            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.email}</td>
                <td>${student.course}</td>
                <td>
                    <a href="edit?id=${student.id}">
                        Edit
                    </a>

                    <a href="delete?id=${student.id}"
                        onclick="return confirm('Are you sure you want to delete this student?');">
                        Delete
                    </a>
                </td>
            </tr>

        </c:forEach>

    </table>

    <a class="button"
       href="register.jsp">
        Register Another Student
    </a>

</div>

</body>

</html>