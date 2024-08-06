package org.example;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class GPACalculatorTest {

    private GPACalculator calculator = GPACalculator.getInstance();

    /** Tests the calculateGPA() method. Test will pass if GPA is calculated accurately by the calculateGPA() method.
     */
    @Test
    public void gpaShouldBeCalculated() {
        ArrayList<Course> courseList = new ArrayList<>();
        String[] gradeArray = {"A+","D","C-"};
        for (int i=0; i<3; i++)
        {
            String name = "Course "+(i+1);
            int credit = i+2;
            String grade = gradeArray[i];
            Course course = new Course(name,credit,grade);
            courseList.add(course);
        }

        double result = calculator.calculateGPA(courseList);
        double expResult = 2.0444444444444443;

        assertEquals(expResult,result);
    }

    /** Tests the calculateGPA() method. Test will pass if exception for 'Invalid Grade' is thrown by the calculateGPA() method.
     */
    @Test
    public void exceptionForGradeShouldBEThrown() {
        ArrayList<Course> courseList = new ArrayList<>();
        String[] gradeArray = {"X","Y","Z"};       // Invalid Grade
        for (int i=0; i<3; i++)
        {
            String name = "Course "+(i+1);
            int credit = i+2;
            String grade = gradeArray[i];
            Course course = new Course(name,credit,grade);
            courseList.add(course);
        }

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateGPA(courseList);
        });

        String result = exception.getMessage();
        String expResult = "Invalid Grade";

        assertEquals(expResult,result);
    }

    /** Tests the calculateGPA() method. Test will pass if exception for 'Invalid Credit' is thrown by the calculateGPA() method.
     */
    @Test
    public void exceptionForCreditShouldBEThrown() {
        ArrayList<Course> courseList = new ArrayList<>();
        String[] gradeArray = {"A","D","C-"};
        for (int i=0; i<3; i++)
        {
            String name = "Course "+i;
            int credit = -i;                                 // Negative or Invalid Credit
            String grade = gradeArray[i];
            Course course = new Course(name,credit,grade);
            courseList.add(course);
        }

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateGPA(courseList);
        });

        String result = exception.getMessage();
        String expResult = "Invalid Credit";

        assertEquals(expResult,result);
    }
    @Test
    public void calculateGPAWithValidInput() {
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Math", 3, "A"));
        courseList.add(new Course("Science", 4, "B"));
        courseList.add(new Course("History", 3, "C"));

        GPACalculator calculator = GPACalculator.getInstance();
        double calculatedGPA = calculator.calculateGPA(courseList);

        assertEquals(3.0, calculatedGPA, 0.01);
    }

    @Test
    public void exceptionForNegativeCreditShouldBeThrown() {
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Course1", -1, "A"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateGPA(courseList);
        });

        String result = exception.getMessage();
        String expResult = "Invalid Credit";

        assertEquals(expResult, result);
    }

    @Test
    public void exceptionForInvalidGradeShouldBeThrown() {
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Course1", 3, "Z"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateGPA(courseList);
        });

        String result = exception.getMessage();
        String expResult = "Invalid Grade";

        assertEquals(expResult, result);
    }

    @Test
    public void calculateGPAWithMinimumCreditAndGrade() {
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Course1", 1, "A+"));

        GPACalculator calculator = GPACalculator.getInstance();
        double calculatedGPA = calculator.calculateGPA(courseList);

        assertEquals(4.3, calculatedGPA, 0.01);
    }

    @Test
    public void calculateGPAWithEmptyCourseList() {
        ArrayList<Course> courseList = new ArrayList<>();

        GPACalculator calculator = GPACalculator.getInstance();
        double calculatedGPA = calculator.calculateGPA(courseList);

        assertNotEquals(0.0, calculatedGPA, 0.01);
    }


        @Test
        public void testCalculateGPAWithValidInput() {
            ArrayList<Course> courseList = new ArrayList<>();
            courseList.add(new Course("Math", 3, "A"));
            courseList.add(new Course("Science", 4, "B"));
            courseList.add(new Course("History", 3, "C"));

            double calculatedGPA = calculator.calculateGPA(courseList);

            assertEquals(3.0, calculatedGPA, 0.01);
        }

        @Test
        public void testCalculateGPAWithEmptyCourseList() {
            ArrayList<Course> courseList = new ArrayList<>();

            double calculatedGPA = calculator.calculateGPA(courseList);

            assertNotEquals(0.0, calculatedGPA, 0.01);
        }

        @Test
        public void testCalculateGPAWithNegativeCredit() {
            ArrayList<Course> courseList = new ArrayList<>();
            courseList.add(new Course("Math", -3, "A"));

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                calculator.calculateGPA(courseList);
            });

            assertEquals("Invalid Credit", exception.getMessage());
        }

        @Test
        public void testCalculateGPAWithInvalidGrade() {
            ArrayList<Course> courseList = new ArrayList<>();
            courseList.add(new Course("Math", 3, "Z"));

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                calculator.calculateGPA(courseList);
            });

            assertEquals("Invalid Grade", exception.getMessage());
        }

        @Test
        public void testCalculateGPAWithAllGradesAndCredits() {
            ArrayList<Course> courseList = new ArrayList<>();
            courseList.add(new Course("Course1", 2, "A+"));
            courseList.add(new Course("Course2", 3, "A"));
            courseList.add(new Course("Course3", 4, "A-"));
            courseList.add(new Course("Course4", 5, "B+"));
            courseList.add(new Course("Course5", 6, "B"));
            courseList.add(new Course("Course6", 7, "B-"));
            courseList.add(new Course("Course7", 8, "C+"));
            courseList.add(new Course("Course8", 9, "C"));
            courseList.add(new Course("Course9", 10, "C-"));
            courseList.add(new Course("Course10", 11, "D+"));
            courseList.add(new Course("Course11", 12, "D"));
            courseList.add(new Course("Course12", 13, "D-"));
            courseList.add(new Course("Course13", 14, "F"));

            double calculatedGPA = calculator.calculateGPA(courseList);

            assertNotEquals(2.0444444444444443, calculatedGPA, 0.01);
        }
    @Test
    public void testExceptionForInvalidCredit() {
        // Create a list of courses with negative credits
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Math", -3, "A"));

        // Verify that an IllegalArgumentException is thrown
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateGPA(courseList);
        });

        // Verify the exception message
        assertEquals("Invalid Credit", exception.getMessage());
    }

    @Test
    public void testGPAStatusBothHighAndLow() {
        // Create a list of courses with both high and low GPA
        ArrayList<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Math", 3, "A+"));
        courseList.add(new Course("Science", 4, "D"));
        courseList.add(new Course("History", 3, "F"));

        // Calculate GPA
        GPACalculator calculator = GPACalculator.getInstance();
        double gpa = calculator.calculateGPA(courseList);

        // Verify GPA status
        assertFalse(calculator.isLowGPA());
        assertFalse(calculator.isHighGPA());
        assertFalse(calculator.isBothHighAndLowGPA());
    }
    }


