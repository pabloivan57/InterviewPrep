package com.pablan.leetcode.medium;

import org.junit.Test;

public class AddAndSearchWordTest {

    @Test
    public void test() {
        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();

        addAndSearchWord.addWord("bad");
        addAndSearchWord.addWord("dad");
        addAndSearchWord.addWord("mad");

        System.out.println(addAndSearchWord.search("pad"));
        System.out.println(addAndSearchWord.search("bad"));
        System.out.println(addAndSearchWord.search(".ad"));
        System.out.println(addAndSearchWord.search("b.."));
    }
}
