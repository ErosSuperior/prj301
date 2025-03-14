package DSA;

import org.junit.Test;
import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testKnapsack_ZeroCapacity() {
        int W = 0;
        int[] wt = {1, 2, 3};
        int[] val = {10, 20, 30};
        int n = wt.length;
        int expected = 0;
        int result = Knapsack.knapsack(W, wt, val, n);
        System.out.println("Test Zero Capacity: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack_EmptyItems() {
        int W = 50;
        int[] wt = {};
        int[] val = {};
        int n = 0;
        int expected = 0;
        int result = Knapsack.knapsack(W, wt, val, n);
        System.out.println("Test Empty Items: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack_NormalCase() {
        int W = 50;
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int n = wt.length;
        int expected = 220;
        int result = Knapsack.knapsack(W, wt, val, n);
        System.out.println("Test Normal Case: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack_SingleItemFits() {
        int W = 10;
        int[] wt = {10};
        int[] val = {100};
        int n = 1;
        int expected = 100;
        int result = Knapsack.knapsack(W, wt, val, n);
        System.out.println("Test Single Item Fits: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }

    @Test
    public void testKnapsack_SingleItemTooHeavy() {
        int W = 5;
        int[] wt = {10};
        int[] val = {100};
        int n = 1;
        int expected = 0;
        int result = Knapsack.knapsack(W, wt, val, n);
        System.out.println("Test Single Item Too Heavy: Expected = " + expected + ", Got = " + result);
        assertEquals(expected, result);
    }
}
