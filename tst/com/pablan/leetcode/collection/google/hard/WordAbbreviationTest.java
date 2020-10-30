package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

import java.util.Arrays;

public class WordAbbreviationTest {

    @Test
    public void test() {
        WordAbbreviation wordAbbreviation = new WordAbbreviation();
        System.out.println(wordAbbreviation.wordsAbbreviation(Arrays.asList("aabaaa", "aacaaa", "aacdaa")));
        System.out.println(wordAbbreviation.wordsAbbreviation(Arrays.asList("like", "god", "internal", "me",
                "internet", "interval", "intension", "face", "intrusion")));
    }
}
