package com.pablan.leetcode.hard;

import org.junit.Test;

public class WordSearchIITest {

    @Test
    public void test() {

        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[] {"oath","pea","eat","rain"};
        WordSearchII wordSearchII = new WordSearchII();

        System.out.println(wordSearchII.findWords(board, words));
    }
}
