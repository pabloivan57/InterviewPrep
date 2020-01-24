package com.pablan.leetcode.collection.hard;

import org.junit.Test;

import java.util.List;

public class PalindromePartitioningTest {

    @Test
    public void test() {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> result =  palindromePartitioning.partition("aab");

        result.forEach(list -> System.out.println(list));

        System.out.println(palindromePartitioning.partitionCuts("aab"));
    }
}
