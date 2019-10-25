package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

public class RemoveDuplicatesTest {

    @Test
    public void test() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.remove(new int [] {2, 2, 2, 11});
        System.out.println(result);
    }
}
