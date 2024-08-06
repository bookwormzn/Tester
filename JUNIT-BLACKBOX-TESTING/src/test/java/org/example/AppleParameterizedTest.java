package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AppleParameterizedTest {

    public int expected;
    public int index;

    public AppleParameterizedTest(int expected, int index) {
        this.expected = expected;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {25, 0},
                {619, 99},
                {139, 19},

        });
    }

    @Test
    public void testApplexPos() {
        Apple apple = new Apple();
        assertEquals(expected, apple.applexPos[index]);
    }


    }

