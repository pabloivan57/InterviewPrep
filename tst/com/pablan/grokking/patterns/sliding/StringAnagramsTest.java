package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

import java.util.List;

public class StringAnagramsTest {

    @Test
    public void test() {
        StringAnagrams stringAnagrams = new StringAnagrams();
        List<Integer> result = stringAnagrams.findStringAnagrams("ppqp", "pq");
        for(Integer idx : result) { // should be 1, 2
            System.out.print(idx);
        }
        System.out.println();

        result = stringAnagrams.findStringAnagrams("abbcabc", "abc");
        for(Integer idx : result) { // should be 2, 3, 4
            System.out.print(idx);
        }
    }
}
