package com.topcoder.arena.srm145div1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class LotteryTest {

    private Lottery test;

    @Before
    public void setUp() throws Exception {
        test = new Lottery();
    }

    @Test
    public void test1() {
        String[] result = test.sortByOdds(
                new String[] { "PICK ANY TWO: 10 2 F F", "PICK TWO IN ORDER: 10 2 T F", "PICK TWO DIFFERENT: 10 2 F T", "PICK TWO LIMITED: 10 2 T T" });
        assertNotNull(result);
        assertEquals(4, result.length);
        assertEquals("PICK TWO LIMITED", result[0]);
        assertEquals("PICK TWO IN ORDER", result[1]);
        assertEquals("PICK TWO DIFFERENT", result[2]);
        assertEquals("PICK ANY TWO", result[3]);
    }

    @Test
    public void test2() {
        String[] result = test.sortByOdds(new String[] { "INDIGO: 93 8 T F", "ORANGE: 29 8 F T", "VIOLET: 76 6 F F", "BLUE: 100 8 T T", "RED: 99 8 T T",
                "GREEN: 78 6 F T", "YELLOW: 75 6 F F" });
        assertNotNull(result);
        assertEquals(7, result.length);
        assertEquals("RED", result[0]);
        assertEquals("ORANGE", result[1]);
        assertEquals("YELLOW", result[2]);
        assertEquals("GREEN", result[3]);
        assertEquals("BLUE", result[4]);
        assertEquals("INDIGO", result[5]);
        assertEquals("VIOLET", result[6]);
    }

    @Test
    public void test3() {
        String[] result = test.sortByOdds(new String[] {});
        assertNotNull(result);
        assertEquals(0, result.length);
    }
}