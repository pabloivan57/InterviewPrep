package com.pablan.leetcode.collection.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordLadderTest {

    @Test
    public void test() {
        WordLadder wordLadder = new WordLadder();
        List<String> dict = new ArrayList<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("cog");
        System.out.println(wordLadder.ladderLength("hit", "cog", dict)); // Should be 5
    }
}
