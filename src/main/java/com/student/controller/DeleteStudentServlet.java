package com.student.controller;

import com.student.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String idParameter = request.getParameter("id");

        if (idParameter == null || idParameter.isBlank()) {
            response.sendRedirect("students");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            response.sendRedirect("students");
            return;
        }

        StudentDAO studentDAO = new StudentDAO();

        boolean deleted = studentDAO.deleteStudent(id);

        if (deleted) {

            response.sendRedirect("students");

        } else {

            response.setContentType("text/html");

            response.getWriter().println(
                    "<h2>Student deletion failed.</h2>"
            );

            response.getWriter().println(
                    "<a href='students'>Back to Student List</a>"
            );
        }
    }
}
