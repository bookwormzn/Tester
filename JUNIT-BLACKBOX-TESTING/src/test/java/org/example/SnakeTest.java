package org.example;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class SnakeTest {

 public Snake snake;

    @Before
    public void setUp() {
        snake = new Snake();
    }



    @Test
   public void testMovementRight() {
        // Test when snake moves right
        snake.moveRight();
        int initialXPos = snake.snakexLength[0];
        snake.movementRight();
        assertTrue(snake.snakexLength[0] > initialXPos);
    }

    // when ı look two test case ı thought that code not update second movement so when ı write same test for down movement it gave me same result.

    @Test
    public void testMovementDown() {
        // Test when snake moves down
        snake.moveDown();
        int initialYPos = snake.snakeyLength[0];
        snake.movementDown();
        assertTrue(snake.snakeyLength[0] > initialYPos);
    }

}

