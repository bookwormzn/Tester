package org.example;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class AppleTest {




    @Test
    public void testApplexPosLastElementTwenty() {
        Apple apple = new Apple();
        assertEquals(139, apple.applexPos[19]);
    }

    @Test
   public  void testAppleyPos() {
        Apple apple = new Apple();
        // Test if appleyPos array has expected length
        assertEquals(100, apple.appleyPos.length);
        // Test if appleyPos array contains expected values
        assertEquals(73, apple.appleyPos[0]);
        assertEquals(667, apple.appleyPos[99]);
    }

    @Test
    public void testApplexPosArray() {
        // Expected x positions array
        int[] expectedApplexPos = {25, 31, 37, 43, 49, 55, 61, 67, 73, 79, 85, 91, 97, 103, 109, 115, 121, 127, 133, 139,
                145, 151, 157, 163, 169, 175, 181, 187, 193, 199, 205, 211, 217, 223, 229, 235, 241, 247, 253, 259, 265,
                271, 277, 283, 289, 295, 301, 307, 313, 319, 325, 331, 337, 343, 349, 355, 361, 367, 373, 379, 385, 391,
                397, 403, 409, 415, 421, 427, 433, 439, 445, 451, 457, 463, 469, 475, 481, 487, 493, 499, 505, 511, 517,
                523, 529, 535, 541, 547, 553, 559, 565, 571, 577, 583, 589, 595, 601, 607, 613, 619, 625};

        // Actual x positions array from the Apple class
        int[] actualApplexPos = new Apple().applexPos;

        // Test the arrays for equality
        assertArrayEquals(expectedApplexPos, actualApplexPos);
    }

}
