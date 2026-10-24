<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
           uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Edit Student</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 400px;
            margin: 60px auto;
            padding: 25px;
            background-color: white;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
        }

        .back {
            display: block;
            margin-top: 15px;
            text-align: center;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Edit Student</h2>

    <c:if test="${not empty errorMessage}">
        <p class="error" role="alert"><c:out value="${errorMessage}" /></p>
    </c:if>

    <form action="update" method="post">

        <input type="hidden"
               name="id"
               value="${student.id}">

        <label>Name:</label>

        <input type="text"
               name="name"
               value="<c:out value='${student.name}' />"
               maxlength="100"
               required>


        <label>Email:</label>

        <input type="email"
               name="email"
               value="<c:out value='${student.email}' />"
               maxlength="150"
               required>


        <label>Course:</label>

        <input type="text"
               name="course"
               value="<c:out value='${student.course}' />"
               maxlength="100"
               required>


        <button type="submit">
            Update Student
        </button>

    </form>

    <a class="back"
       href="students">
        Back to Student List
    </a>

</div>

</body>

</html>
