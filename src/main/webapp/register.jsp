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

        <c:if test="${not empty errorMessage}">
            <p class="error" role="alert"><c:out value="${errorMessage}" /></p>
        </c:if>

        <form action="Register" method="post">

            <label for="name">Name:</label>

            <input type="text"
                   id="name"
                   name="name"
                   value="<c:out value='${name}' />"
                   placeholder="Enter your name"
                   maxlength="100"
                   required>

            <br><br>

            <label for="email">Email:</label>

            <input type="email"
                   id="email"
                   name="email"
                   value="<c:out value='${email}' />"
                   placeholder="Enter your email"
                   maxlength="150"
                   required>

            <br><br>

            <label for="course">Course:</label>

            <input type="text"
                   id="course"
                   name="course"
                   value="<c:out value='${course}' />"
                   placeholder="Enter your course"
                   maxlength="100"
                   required>

            <br><br>

            <button type="submit">Register</button>

        </form>

    </div>

</body>

</html>
