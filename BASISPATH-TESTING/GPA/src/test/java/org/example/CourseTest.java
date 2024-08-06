package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class CourseTest {

    @Test
    public void testGetName() {
        Course course = new Course("Math", 3, "A");
        assertEquals("Math", course.getName());
    }

    @Test
    public void testSetName() {
        Course course = new Course("Math", "A", 3);
        course.setName("Physics");
        assertEquals("Physics", course.getName());
    }

    @Test
    public void testGetCredit() {
        Course course = new Course("English", 4, "B");
        assertEquals(4, course.getCredit());
    }

    @Test
    public void testSetCredit() {
        Course course = new Course("Math", "A", 3);
        course.setCredit(2);
        assertEquals(2, course.getCredit());
    }

    @Test
    public void testGetGrade() {
        Course course = new Course("History", 3, "C");
        assertEquals("C", course.getGrade());
    }

    @Test
    public void testSetGrade() {
        Course course = new Course("Math", "A", 3);
        course.setGrade("A+");
        assertEquals("A+", course.getGrade());
    }
}
