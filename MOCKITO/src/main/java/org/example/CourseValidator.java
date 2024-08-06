package org.example;


public class CourseValidator {

    /** Validates the course details.
     * @param name A String representing the name of a course.
     * @param credit An integer representing the credit of a course.
     * @param grade A String representing the grade of a course.
     * @return true if the course details are valid, false otherwise.
     */
    public boolean isValid(String name, int credit, String grade) {
        // Perform validation logic here
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Course name cannot be empty.");
            return false;
        }

        if (credit <= 0) {
            System.out.println("Invalid credit value for the course.");
            return false;
        }

        if (!isValidGrade(grade)) {
            System.out.println("Invalid grade for the course.");
            return false;
        }

        // All validation passed
        return true;
    }

    /** Validates the grade of a course.
     * @param grade A String representing the grade of a course.
     * @return true if the grade is valid, false otherwise.
     */
    private boolean isValidGrade(String grade) {
        // Assuming the grade must be one of the following: A+, A, A-, ..., F
        String[] validGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};

        for (String validGrade : validGrades) {
            if (validGrade.equals(grade)) {
                return true;
            }
        }

        return false;
    }
}
