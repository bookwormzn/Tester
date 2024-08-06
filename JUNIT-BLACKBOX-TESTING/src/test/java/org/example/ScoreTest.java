package org.example;

import org.junit.After;
import org.junit.Before;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class ScoreTest {

   public Score score;

    @Before
    public void setUp() {
        score = new Score();
    }



    @After
    public void tearDown() {
        score = null;
        // Delete the highscore.dat file after each test
        File file = new File("highscore.dat");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
   public  void testIncreaseScore() {
        score.increaseScore();
        assertEquals(1, score.getScore());
    }

    @Test
   public  void testResetScore() {
        score.increaseScore();
        score.resetScore();
        assertEquals(0, score.getScore());
    }



    @Test
    public void testGetHighScore() {
        // Test if it returns a string
        assertNotNull(score.getHighScore());

    }

    @Test
    public void testSaveNewScore() {
        score.saveNewScore();
        assertTrue(new File("highscore.dat").exists());
    }
}
