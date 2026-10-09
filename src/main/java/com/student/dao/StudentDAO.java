package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;

public class StudentDAO {

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT id, name, email, course FROM students";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Database connected successfully.");

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String course = resultSet.getString("course");

                System.out.println(
                    "Student: " + id + " | " +
                    name + " | " +
                    email + " | " +
                    course
                );

                Student student = new Student(
                    id,
                    name,
                    email,
                    course
                );

                students.add(student);
            }

            System.out.println(
                "Total students retrieved: " + students.size()
            );

        } catch (Exception e) {

            System.out.println("Error retrieving students:");
            e.printStackTrace();
        }

        return students;
    }


    public Student getStudentById(int id) {

    String sql = """
            SELECT id, name, email, course
            FROM students
            WHERE id = ?
            """;

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        try (ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {

                return new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("course")
                );
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
    }


    public boolean updateStudent(Student student) {

    String sql = """
            UPDATE students
            SET name = ?, email = ?, course = ?
            WHERE id = ?
            """;

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3, student.getCourse());
        statement.setInt(4, student.getId());

        int rowsUpdated =
                statement.executeUpdate();

        return rowsUpdated > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
    }


    public boolean deleteStudent(int id) {

    String sql = "DELETE FROM students WHERE id = ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;

    } catch (Exception e) {

        e.printStackTrace();
        return false;
    }
    }
}

