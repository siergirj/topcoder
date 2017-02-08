package com.topcoder.arena;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ABBADiv1Test {

    private ABBADiv1 test;

    @Before
    public void setUp() throws Exception {
        test = new ABBADiv1();
    }

    @Test
    public void testCanObtainExample1() {
        assertEquals(ABBADiv1.TRUE, test.canObtain("A", "BABA"));
    }

    @Test
    public void testCanObtainExample2() {
        assertEquals(ABBADiv1.TRUE, test.canObtain("BAAAAABAA", "BAABAAAAAB"));
    }

    @Test
    public void testCanObtainExample3() {
        assertEquals(ABBADiv1.FALSE, test.canObtain("A", "ABBA"));
    }

    @Test
    public void testCanObtainExample4() {
        assertEquals(ABBADiv1.TRUE, test.canObtain("AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
    }

    @Test
    public void testCanObtainExample5() {
        assertEquals(ABBADiv1.FALSE, test.canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
    }

    @Test
    public void testCanObtainExample6() {
        assertEquals(ABBADiv1.TRUE, test.canObtain("AAABAAABB", "AAABAAABBAA"));
    }

    @Test
    public void testCanObtainExample7() {
        assertEquals(ABBADiv1.TRUE, test.canObtain("AAABAAABB", "BBBAAABAAA"));
    }
}
