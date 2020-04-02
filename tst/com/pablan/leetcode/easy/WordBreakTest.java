package com.pablan.leetcode.easy;

import com.pablan.leetcode.medium.WordBreak;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTest {

    @Test
    public void test() {
        WordBreak wordBreak = new WordBreak();
        List<String> dict = new ArrayList<>();
        dict.add("cats");
        dict.add("and");
        dict.add("dog");

        System.out.println(wordBreak.wordBreak("catsanddog", dict));
        List<List<String>> words = wordBreak.wordBreakRecursive("catsanddog", dict);
        words.forEach(w -> System.out.println(w));
    }
}
