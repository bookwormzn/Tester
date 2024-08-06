package org.example;


public class DeanListChecker {

    /** Checks if a student is eligible for the Dean's List based on GPA.
     * @param gpa The GPA of the student.
     * @return true if eligible, false otherwise.
     */
    public boolean isEligibleForDeansList(double gpa) {
        // Assuming a GPA of 3.7 or higher is required for the Dean's List
        return gpa >= 3.7;
    }
}
