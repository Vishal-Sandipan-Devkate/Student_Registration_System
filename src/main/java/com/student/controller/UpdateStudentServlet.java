package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.model.Student;

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

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String course =
                request.getParameter("course");

        Student student = new Student(
                id,
                name,
                email,
                course
        );

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
