package com.pablan.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class AddAndSearchWord {

    TrieNode root = null;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Design a data structure that supports the following two operations:
     *
     * void addWord(word)
     * bool search(word)
     * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
     *
     * Example:
     *
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     */

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] letters =  word.toCharArray();

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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] letters  = word.toCharArray();

        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);

        for(int i = 0 ; i < letters.length; i++) {
            char key = letters[i];

            if(key == '.') {
               int levelSize = queue.size();

               // We have no TrieNodes to process but we are still looking for letter
               // doesn't have the prefix
               if(levelSize == 0) {
                   return false;
               }

               for(int j = 0; j < levelSize; j++) {
                   TrieNode node = queue.poll();

                   for(TrieNode child : node.getLinks()) {
                       if(child != null) {
                           // add next level links
                           queue.add(child);
                       }
                   }
               }
            } else {
                int levelSize = queue.size();

                if(levelSize == 0) {
                    return false;
                }

                for(int j = 0; j < levelSize; j++) {
                    TrieNode node = queue.poll();

                    if(node.containsKey(key)) {
                        queue.add(node.get(key));
                    }
                }
            }
        }

        boolean hasPrefix = false;
        while(!queue.isEmpty()) {
            TrieNode node = queue.poll();
            hasPrefix = hasPrefix || node.isEnd();
        }

        return hasPrefix;
    }
}
