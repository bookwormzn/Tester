package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/** Represents the course list which contains courses.
 */
public class CourseList {
    private ArrayList<Course> courseList;

    /** No-arg constructor to make an instance of class.
     */
    public CourseList()
    {
        courseList = new ArrayList<>();
    }

    /** Gets the course list.
     * @return An array list containing the courses.
     */
    public ArrayList<Course> getCourseList()
    {
        return courseList;
    }

    /** Sets the course list.
     * @param courseList An array list containing the courses.
     */
    public void setCourseList(ArrayList<Course> courseList)
    {
        this.courseList = courseList;
    }

    /** Adds the course(s) in course list.
     * @param numOfCourses An integer representing the number of courses to be added in course list.
     * @throws IllegalArgumentException if number of courses are invalid (zero or negative).
     */
    public void addCourse(int numOfCourses)
    {
        if (numOfCourses > 0) {
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < numOfCourses; i++) {
                System.out.println("Please enter the name of course " + (i + 1));
                String name = input.next();
                System.out.println("Please enter the credit of course " + (i + 1));
                int credit = input.nextInt();
                System.out.println("Please enter the grade you achieved in course " + (i + 1));
                String grade = input.next();
                Course course = new Course(name, credit, grade);
                courseList.add(course);
            }
        }
        else
        {
            throw new IllegalArgumentException("Invalid number of courses");
        }
    }

    public void addCourse(Course course) {
    }
}
