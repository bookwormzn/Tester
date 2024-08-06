package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import static org.testng.AssertJUnit.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class GPACalculatorIntegrationTest {

    @Mock
    private Course course1;

    @Mock
    private Course course2;

    @InjectMocks
    private GPACalculator gpaCalculator;

    public GPACalculatorIntegrationTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateGPA_WithValidCourses() {
        // Mock Course objects
        when(course1.getName()).thenReturn("Math");
        when(course1.getCredit()).thenReturn(3);
        when(course1.getGrade()).thenReturn("A");

        when(course2.getName()).thenReturn("Science");
        when(course2.getCredit()).thenReturn(4);
        when(course2.getGrade()).thenReturn("B+");

        // Create course list
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        // Calculate GPA
        double gpa = gpaCalculator.calculateGPA(courseList);

        // Verify
        assertEquals(3.6, gpa);
    }

    @Test
    public void testCalculateGPA_WithNoCourses() {
        // Create an empty course list
        ArrayList<Course> courseList = new ArrayList<>();

        // Calculate GPA
        double gpa = gpaCalculator.calculateGPA(courseList);

        // Verify
        assertTrue(Double.isNaN(gpa));
    }

    @Test
    public void testCalculateGPA_WithNoCredits() {
        // Mock Course objects with no credits
        when(course1.getName()).thenReturn("Math");
        when(course1.getCredit()).thenReturn(0); // Invalid credit
        when(course1.getGrade()).thenReturn("A");

        when(course2.getName()).thenReturn("Science");
        when(course2.getCredit()).thenReturn(0); // Invalid credit
        when(course2.getGrade()).thenReturn("B+");

        // Create course list
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        // Calculate GPA and verify exception
        assertThrows(IllegalArgumentException.class, () -> gpaCalculator.calculateGPA(courseList));
    }
    @Test
    public void testCalculateGPA_WithInvalidGrade() {
        // Mock Course objects with invalid grades
        when(course1.getName()).thenReturn("Math");
        when(course1.getCredit()).thenReturn(3);
        when(course1.getGrade()).thenReturn("A");

        when(course2.getName()).thenReturn("Science");
        when(course2.getCredit()).thenReturn(4);
        when(course2.getGrade()).thenReturn("X"); // Invalid grade

        // Create course list
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);

        // Calculate GPA and verify exception
        assertThrows(IllegalArgumentException.class, () -> gpaCalculator.calculateGPA(courseList));
    }

    @Test
    public void testCalculateGPA_WithEmptyCourseList() {
        // Create an empty course list
        ArrayList<Course> courseList = new ArrayList<>();

        // Calculate GPA
        double gpa = gpaCalculator.calculateGPA(courseList);

        // Verify
        assertTrue(Double.isNaN(gpa));
    }


}
