package com.pablan.grokking.patterns.topk;

import org.junit.Test;

public class FrequencySortTest {

    @Test
    public void test() {
        String result = new FrequencySort().sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = new FrequencySort().sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
