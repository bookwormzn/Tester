package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class CourseListIntegrationTest {

    @Mock
    private Course course;

    @InjectMocks
    private CourseList courseList;

    public CourseListIntegrationTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCourse_WithValidCourse() {
        // Mock Course object
        Mockito.when(course.getName()).thenReturn("Math");
        Mockito.when(course.getCredit()).thenReturn(3);
        Mockito.when(course.getGrade()).thenReturn("A");

        // Add course to course list
        courseList.addCourse(course);

        // Verify
        assertEquals(0, courseList.getCourseList().size());
    }

    @Test
    public void testAddCourse_WithMultipleCourses() {
        // Mock Course objects
        Course course1 = Mockito.mock(Course.class);
        Mockito.when(course1.getName()).thenReturn("Math");
        Mockito.when(course1.getCredit()).thenReturn(3);
        Mockito.when(course1.getGrade()).thenReturn("A");

        Course course2 = Mockito.mock(Course.class);
        Mockito.when(course2.getName()).thenReturn("Science");
        Mockito.when(course2.getCredit()).thenReturn(4);
        Mockito.when(course2.getGrade()).thenReturn("B");

        // Add courses to course list
        courseList.addCourse(course1);
        courseList.addCourse(course2);

        // Verify
        assertEquals(0, courseList.getCourseList().size());
    }

    @Test
    public void testAddCourse_WithNoCourses() {
        // Create an empty list of courses
        ArrayList<Course> courses = new ArrayList<>();

        // Set the course list
        courseList.setCourseList(courses);

        // Verify
        assertTrue(courseList.getCourseList().isEmpty());
    }

    @Test
    public void testAddCourse_WithZeroCredits() {
        // Mock Course object with zero credits
        Mockito.when(course.getName()).thenReturn("Math");
        Mockito.when(course.getCredit()).thenReturn(0);
        Mockito.when(course.getGrade()).thenReturn("A");

        // Add course to course list
        courseList.addCourse(course);

        // Verify
        assertEquals(0, courseList.getCourseList().size());
    }
    @Test
    public void testAddCourse_WithNullCourse() {
        // Mock a null Course object
        Course nullCourse = null;

        // Add null course to course list
        courseList.addCourse(nullCourse);

        // Verify
        assertEquals(0, courseList.getCourseList().size());
    }

}
