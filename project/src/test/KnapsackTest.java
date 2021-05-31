package test;

import DP.Knapsack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void get() {
        Knapsack knapsack = new Knapsack();
        int b = knapsack.get(5);
        assertEquals(b, 25);
    }
}