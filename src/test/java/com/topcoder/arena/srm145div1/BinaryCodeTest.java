package com.topcoder.arena.srm145div1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BinaryCodeTest {

    private BinaryCode test;

    @Before
    public void setUp() throws Exception {
        test = new BinaryCode();
    }

    @Test
    public void test1() {
        String[] result = test.decode("123210122");
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("011100011", result[0]);
        assertEquals("NONE", result[1]);
    }

    @Test
    public void test2() {
        String[] result = test.decode("11");
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("01", result[0]);
        assertEquals("10", result[1]);
    }

    @Test
    public void test3() {
        String[] result = test.decode("22111");
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("NONE", result[0]);
        assertEquals("11001", result[1]);
    }

    @Test
    public void test4() {
        String[] result = test.decode("123210120");
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("NONE", result[0]);
        assertEquals("NONE", result[1]);
    }
    
    @Test
    public void test5() {
        String[] result = test.decode("3");
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("NONE", result[0]);
        assertEquals("NONE", result[1]);
    }
    
    @Test
    public void test6() {
        String[] result = test.decode("12221112222221112221111111112221111");
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("01101001101101001101001001001101001", result[0]);
        assertEquals("10110010110110010110010010010110010", result[1]);
    }
}
