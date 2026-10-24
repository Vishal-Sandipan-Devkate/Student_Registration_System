package com.student.controller;

import com.student.dao.DBConnection;
import com.student.validation.StudentValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from registration form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        String validationError =
            StudentValidator.validate(name, email, course);

        if (validationError != null) {
            request.setAttribute("errorMessage", validationError);
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("course", course);
            request.getRequestDispatcher("register.jsp")
                .forward(request, response);
            return;
        }

        name = name.trim();
        email = email.trim();
        course = course.trim();

        String sql = """
                INSERT INTO students (name, email, course)
                VALUES (?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, course);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                response.sendRedirect("students");

            } else {

                response.getWriter().println(
                        "Registration failed."
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();

                request.setAttribute("errorMessage",
                    "Unable to register the student. The email may already be registered.");
                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.setAttribute("course", course);
                request.getRequestDispatcher("register.jsp")
                    .forward(request, response);
        }
    }
}