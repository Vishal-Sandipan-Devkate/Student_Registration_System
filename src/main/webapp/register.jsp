<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Student Registration</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

    <div class="container">

        <h2>Student Registration</h2>

        <form action="Register" method="post">

            <label for="name">Name:</label>

            <input type="text"
                   id="name"
                   name="name"
                   placeholder="Enter your name"
                   required>

            <br><br>

            <label for="email">Email:</label>

            <input type="email"
                   id="email"
                   name="email"
                   placeholder="Enter your email"
                   required>

            <br><br>

            <label for="course">Course:</label>

            <input type="text"
                   id="course"
                   name="course"
                   placeholder="Enter your course"
                   required>

            <br><br>

            <button type="submit">Register</button>

        </form>

    </div>

</body>

</html>
