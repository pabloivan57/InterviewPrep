package com.pablan.leetcode.collection.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     *
     * Pablo's notes: This problem is actually straightforward, the trick is to create a map of possible
     * "transitions". For example
     * you could reach hot from 3 options, [*ot] : h*t : ho*
     * now imagine also dot from 3 options [*ot] : d*t : do*
     *
     * This means you have *ot -> hot, dog
     * so, because hot can be mapped to *ot we can find other possible words that we can transition to... for example dot
     * That is the gist of the algorithm,
     * 1.- for each word. Create these prefixes
     * 2.- From starting word, transform it to prefix form and explore each path
     *     hit -> *it,            h*t,            hi*t
     *          [  words  ]      [ words  ]        [words]
     * 3.- Basically do a BFS of each of those words and it's prefix possibilities. Of course keep track of visited
     * words
     * 4.- When we reach the end word. return how deep it is in the BFS. Why BFS? Because it returns the shortest path
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Map.Entry<String, Integer>> Q = new LinkedList<Map.Entry<String, Integer>>();
        Q.add(Map.entry(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Map.Entry<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(Map.entry(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
