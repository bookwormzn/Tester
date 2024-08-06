package org.example;

/** Represents a course of a program.
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
public class Course
{
    private String name;
    private int credit;
    private String grade;
    private CourseList courseList;
    private CourseValidator courseValidator;

    /** No-arg constructor to make an instance of class.
     */
    public Course(String math, String a, int i)
    {
        name = "";
        credit = 0;
        grade = "";
        courseList = new CourseList(); // Instantiate CourseList
        courseValidator = new CourseValidator(); // Instantiate CourseValidator
    }

    /** Parameterized constructor to make an instance of class.
     * @param name A String representing the name of a course.
     * @param credit An integer representing the credit of a course.
     * @param grade A String representing the grade of a course.
     */
    public Course(String name, int credit, String grade)
    {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
        this.courseList = new CourseList(); // Instantiate CourseList
        this.courseValidator = new CourseValidator(); // Instantiate CourseValidator
    }

    /** Gets the name of a course.
     * @return A String representing the name of a course.
     */
    public String getName() {
        return name;
    }

    /** Sets the name of a course.
     * @param name A String representing the name of a course.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the credit of a course.
     *
     * @return An integer representing the credit of a course.
     */
    public int getCredit() {
        return credit;
    }

    /** Sets the credit of a course.
     * @param credit An integer representing the credit of a course.
     */
    public void setCredit(int credit) {
        this.credit = credit;
    }

    /** Gets the grade of a course.
     * @return A String representing the grade of a course.
     */
    public String getGrade() {
        return grade;
    }

    /** Sets the grade of a course.
     * @param grade A String representing the grade of a course.
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
