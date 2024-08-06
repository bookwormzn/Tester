package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseListTest {

    @Test
    public void testAddCourseWithValidInput() {
        // Prepare input for testing
        String input = "Math\n3\nA\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CourseList courseList = new CourseList();
        courseList.addCourse(1);

        ArrayList<Course> courses = courseList.getCourseList();

        assertEquals(1, courses.size());
        assertEquals("Math", courses.get(0).getName());
        assertEquals(3, courses.get(0).getCredit());
        assertEquals("A", courses.get(0).getGrade());
    }

    @Test
    public void testAddCourseWithZeroNumOfCourses() {
        CourseList courseList = new CourseList();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            courseList.addCourse(0);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Invalid number of courses";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testAddCourseWithNegativeNumOfCourses() {
        CourseList courseList = new CourseList();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            courseList.addCourse(-1);
        });

        String actualMessage = exception.getMessage();
        String expectedMessage = "Invalid number of courses";

        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void testAddMultipleCoursesWithValidInput() {
        // Prepare input for testing
        String input = "Math\n3\nA\nEnglish\n4\nB+\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CourseList courseList = new CourseList();
        courseList.addCourse(2); // Adding two courses

        ArrayList<Course> courses = courseList.getCourseList();

        assertEquals(2, courses.size());

        // Check details of first course
        assertEquals("Math", courses.get(0).getName());
        assertEquals(3, courses.get(0).getCredit());
        assertEquals("A", courses.get(0).getGrade());

        // Check details of second course
        assertEquals("English", courses.get(1).getName());
        assertEquals(4, courses.get(1).getCredit());
        assertEquals("B+", courses.get(1).getGrade());
    }


}
