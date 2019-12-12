package com.pablan.leetcode.medium;

import org.junit.Test;

public class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }
}
