package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

public class RemoveKeyTest {

    @Test
    public void test() {
        RemoveKey removeKey = new RemoveKey();
        int result = removeKey.solve( new int[] {3, 2, 3, 6, 3, 10, 9, 3}, 3);

        System.out.println(result);
    }
}
