package com.pablan.leetcode.medium;

public class Trie {

    /**
     * Implement a trie with insert, search, and startsWith methods.
     *
     * Example:
     *
     * Trie trie = new Trie();
     *
     * trie.insert("apple");
     * trie.search("apple");   // returns true
     * trie.search("app");     // returns false
     * trie.startsWith("app"); // returns true
     * trie.insert("app");
     * trie.search("app");     // returns true
     * Note:
     *
     * You may assume that all inputs are consist of lowercase letters a-z.
     * All inputs are guaranteed to be non-empty strings.
     */
    private TrieNode root = null;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] letters = word.toCharArray();

        TrieNode node = root;
        for(int i = 0; i < letters.length; i++) {
            char key = letters[i];

            if(!node.containsKey(key)) {
                node.put(key, new TrieNode());
            }
            node = node.get(key);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);

        return node != null;
    }

    public TrieNode searchPrefix(String prefix) {
        char[] letters = prefix.toCharArray();

        TrieNode node = root;
        for(int i = 0; i < letters.length; i++) {
            char key = letters[i];

            if(!node.containsKey(key)) {
                return null;
            }

            node = node.get(key);
        }

        return node;
    }
}
