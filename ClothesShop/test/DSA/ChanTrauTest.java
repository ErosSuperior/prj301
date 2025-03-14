package DSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChanTrauTest {

    @Test
    public void testMaxMatching_BasicCase() {
        ChanTrau.n = 3;
        ChanTrau.m = 3;
        ChanTrau.graph = new int[][] {
            {1, 0, 1},
            {0, 1, 0},
            {1, 1, 0}
        };
        int expected = 3;
        int result = ChanTrau.maxMatching();
        System.out.println("Test Basic Case: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxMatching_NoMatching() {
        ChanTrau.n = 3;
        ChanTrau.m = 3;
        ChanTrau.graph = new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int expected = 0;
        int result = ChanTrau.maxMatching();
        System.out.println("Test No Matching: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxMatching_AllMatched() {
        ChanTrau.n = 3;
        ChanTrau.m = 3;
        ChanTrau.graph = new int[][] {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int expected = 3;
        int result = ChanTrau.maxMatching();
        System.out.println("Test All Matched: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxMatching_MoreBuffaloesThanFields() {
        ChanTrau.n = 5;
        ChanTrau.m = 3;
        ChanTrau.graph = new int[][] {
            {1, 0, 1},
            {0, 1, 0},
            {1, 1, 0},
            {1, 0, 0},
            {0, 1, 1}
        };
        int expected = 3;
        int result = ChanTrau.maxMatching();
        System.out.println("Test More Buffaloes Than Fields: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxMatching_MoreFieldsThanBuffaloes() {
        ChanTrau.n = 3;
        ChanTrau.m = 5;
        ChanTrau.graph = new int[][] {
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 1, 1, 1}
        };
        int expected = 3;
        int result = ChanTrau.maxMatching();
        System.out.println("Test More Fields Than Buffaloes: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }
}
