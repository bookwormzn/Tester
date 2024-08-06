package org.example;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameplayTest {

    public Gameplay gameplay;

    @Before
    public void setUp() {
        gameplay = new Gameplay();
    }

    @Test
   public  void testActionPerformed() {
        // Create an ActionEvent to simulate timer action
        ActionEvent actionEvent = new ActionEvent(gameplay, ActionEvent.ACTION_PERFORMED, "");

        // Call actionPerformed method and check if it works without errors
        assertDoesNotThrow(() -> gameplay.actionPerformed(actionEvent));
    }

    @Test
    public void testKeyboardInputHandling() {
        // Test key press for spacebar
        assertDoesNotThrow(() -> gameplay.keyPressed(new KeyEvent(gameplay, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_SPACE)));

        // Test key press for arrow up
        assertDoesNotThrow(() -> gameplay.keyPressed(new KeyEvent(gameplay, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP)));

        // Test key press for arrow down
        assertDoesNotThrow(() -> gameplay.keyPressed(new KeyEvent(gameplay, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN)));

        // Test key press for arrow left
        assertDoesNotThrow(() -> gameplay.keyPressed(new KeyEvent(gameplay, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT)));

        // Test key press for arrow right
        assertDoesNotThrow(() -> gameplay.keyPressed(new KeyEvent(gameplay, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT)));

        // Test key press for shift
        assertDoesNotThrow(() -> gameplay.keyPressed(new KeyEvent(gameplay, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), KeyEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SHIFT)));

        // Test key release for shift
        assertDoesNotThrow(() -> gameplay.keyReleased(new KeyEvent(gameplay, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), KeyEvent.SHIFT_DOWN_MASK, KeyEvent.VK_SHIFT)));
    }
}
