package com.student.controller;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        StudentDAO studentDAO = new StudentDAO();

        Student student =
                studentDAO.getStudentById(id);

        if (student != null) {

            request.setAttribute("student", student);

            request.getRequestDispatcher("edit.jsp")
                   .forward(request, response);

        } else {

            response.sendRedirect("students");
        }
    }
}
