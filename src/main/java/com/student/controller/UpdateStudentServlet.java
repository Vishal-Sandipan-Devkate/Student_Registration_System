package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.model.Student;
import com.student.validation.StudentValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String course =
                request.getParameter("course");

        int id;
        try {
            id = Integer.parseInt(idParameter);
        } catch (NumberFormatException exception) {
            response.sendRedirect("students");
            return;
        }

        String validationError =
                StudentValidator.validate(name, email, course);

        Student student = new Student(
                id,
                name == null ? null : name.trim(),
                email == null ? null : email.trim(),
                course == null ? null : course.trim()
        );

        if (validationError != null) {
            request.setAttribute("errorMessage", validationError);
            request.setAttribute("student", student);
            request.getRequestDispatcher("edit.jsp")
                    .forward(request, response);
            return;
        }

        StudentDAO studentDAO =
                new StudentDAO();

        boolean updated =
                studentDAO.updateStudent(student);

        if (updated) {

            response.sendRedirect("students");

        } else {

            response.getWriter().println(
                    "<h2>Student update failed.</h2>"
            );
        }
    }
}
