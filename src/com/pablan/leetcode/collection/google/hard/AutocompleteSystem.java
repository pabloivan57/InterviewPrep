package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AutocompleteSystem {

    /**
     *  Design a search autocomplete system for a search engine. Users may input a sentence
     *  (at least one word and end with a special character '#'). For each character they type except '#',
     *  you need to return the top 3 historical hot sentences that have prefix the same as the part of
     *  sentence already typed. Here are the specific rules:
     *
     * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
     * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
     * If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
     * If less than 3 hot sentences exist, then just return as many as you can.
     * When the input is a special character, it means the sentence ends, and in this case,
     * you need to return an empty list.
     * Your job is to implement the following functions:
     *
     * The constructor function:
     *
     * AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
     * The input is historical data. Sentences is a string array consists of previously typed sentences.
     * Times is the corresponding times a sentence has been typed. Your system should record these historical data.
     *
     * Now, the user wants to input a new sentence. The following function will provide the next character the user types:
     *
     * List<String> input(char c): The input c is the next character typed by the user.
     * The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
     * Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical
     * hot sentences that have prefix the same as the part of sentence already typed.
     *
     *
     * Example:
     * Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
     * The system have already tracked down the following sentences and their corresponding times:
     * "i love you" : 5 times
     * "island" : 3 times
     * "ironman" : 2 times
     * "i love leetcode" : 2 times
     * Now, the user begins another search:
     *
     * Operation: input('i')
     * Output: ["i love you", "island","i love leetcode"]
     * Explanation:
     * There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same
     * hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be
     * in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
     *
     * Operation: input(' ')
     * Output: ["i love you","i love leetcode"]
     * Explanation:
     * There are only two sentences that have prefix "i ".
     *
     * Operation: input('a')
     * Output: []
     * Explanation:
     * There are no sentences that have prefix "i a".
     *
     * Operation: input('#')
     * Output: []
     * Explanation:
     * The user finished the input, the sentence "i a" should be saved as a historical sentence in system.
     * And the following input will be counted as a new search.
     *
     * Pablo's notes: This is using a Trie almost the same way we have used before. With the exception that
     * we keep some metadata in the end nodes, remember how nodes representing words have an end boolean? Well
     * we use that for the metadata, we first set end of word to Yes + and keep track of  the count
     *
     * Then we lookup for a prefix node, and then search all children for words. Once you find ends
     * simply add them to a list and sort the list by the amount of times in descending order
     * then return top  3
     */


    TrieNode root;
    String input;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();

        for(int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            add(input, 1);
            input = "";
            return Collections.emptyList();
        }

        input += c;

        // Find all possibilities
        TrieNode prefixRoot = lookup(input);
        List<Map.Entry<String, Integer>> possibilities  = new ArrayList<>();
        traverse(prefixRoot, possibilities);

        // Order them in natural order
        Collections.sort(possibilities, (a, b) -> b.getValue() - a.getValue());

        List<String> result = new ArrayList<>();
        // Return top 3
        for(int i = 0; i < Math.min(possibilities.size(), 3); i++) {
            result.add(possibilities.get(i).getKey());
        }
        return result;
    }

    private TrieNode lookup(String prefix) {
        TrieNode current = root;

        for(int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if(!current.children.containsKey(letter)) {
                return null;
            }

            current = current.children.get(letter);
        }

        return current;
    }

    private void add(String word, int count) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(!current.children.containsKey(letter)) {
                current.children.put(letter, new TrieNode());
            }

           current = current.children.get(letter);
        }

        current.isEnd = true;
        current.word =  word;
        current.count = current.count + count;
    }

    private void traverse(TrieNode root, List<Map.Entry<String, Integer>> result) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.addAll(root.children.values());

        TrieNode current = null;
        while(!queue.isEmpty())  {
            current = queue.poll();
            Collection<TrieNode> children = current.children.values();
            for(TrieNode child : children) {
                if(child.isEnd) {
                    result.add(Map.entry(child.word, child.count));
                }
                queue.add(child);
            }
        }
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        public String word;
        public int count;

        public TrieNode()  {
            children = new HashMap<>();
        }
    }
}
