package org.example;

import org.example.Course;
import org.example.CourseValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class CourseValidatorIntegrationTest {

    @Mock
    private Course course;

    @InjectMocks
    private CourseValidator courseValidator;

    public CourseValidatorIntegrationTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsValid_WithValidCourse() {
        // Mock Course object with valid values
        when(course.getName()).thenReturn("Math");
        when(course.getCredit()).thenReturn(3);
        when(course.getGrade()).thenReturn("A");

        // Validate course
        assertTrue(courseValidator.isValid(course.getName(), course.getCredit(), course.getGrade()));
    }

    @Test
    public void testIsValid_WithInvalidName() {
        // Mock Course object with invalid name
        when(course.getName()).thenReturn(""); // Empty name
        when(course.getCredit()).thenReturn(3);
        when(course.getGrade()).thenReturn("A");

        // Validate course
        assertFalse(courseValidator.isValid(course.getName(), course.getCredit(), course.getGrade()));
    }

    @Test
    public void testIsValid_WithInvalidCredit() {
        // Mock Course object with invalid credit
        when(course.getName()).thenReturn("Math");
        when(course.getCredit()).thenReturn(-2); // Negative credit
        when(course.getGrade()).thenReturn("A");

        // Validate course
        assertFalse(courseValidator.isValid(course.getName(), course.getCredit(), course.getGrade()));
    }

    @Test
    public void testIsValid_WithInvalidGrade() {
        // Mock Course object with invalid grade
        when(course.getName()).thenReturn("Math");
        when(course.getCredit()).thenReturn(3);
        when(course.getGrade()).thenReturn("X"); // Invalid grade

        // Validate course
        assertFalse(courseValidator.isValid(course.getName(), course.getCredit(), course.getGrade()));
    }

    @Test
    public void testIsValid_WithEmptyNameAndInvalidCredit() {
        // Mock Course object with empty name and invalid credit
        when(course.getName()).thenReturn(""); // Empty name
        when(course.getCredit()).thenReturn(0); // Invalid credit
        when(course.getGrade()).thenReturn("A");

        // Validate course
        assertFalse(courseValidator.isValid(course.getName(), course.getCredit(), course.getGrade()));
    }
}
