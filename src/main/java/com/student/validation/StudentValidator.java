package com.student.validation;

public final class StudentValidator {

    private StudentValidator() {
    }

    public static String validate(String name, String email, String course) {
        if (isBlank(name) || isBlank(email) || isBlank(course)) {
            return "Name, email, and course are required.";
        }

        if (name.trim().length() > 100 || course.trim().length() > 100) {
            return "Name and course must be 100 characters or fewer.";
        }

        if (email.trim().length() > 150) {
            return "Email must be 150 characters or fewer.";
        }

        if (!email.trim().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            return "Enter a valid email address.";
        }

        return null;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}