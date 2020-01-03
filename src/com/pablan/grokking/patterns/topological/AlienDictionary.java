package com.pablan.grokking.patterns.topological;

import java.util.*;

public class AlienDictionary {

    /**
     * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
     * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the
     * rules of this new language. Derive the order of letters in this language.
     *
     * Example 1:
     *
     * Input:
     * [
     *   "wrt",
     *   "wrf",
     *   "er",
     *   "ett",
     *   "rftt"
     * ]
     *
     * Output: "wertf"
     * Example 2:
     *
     * Input:
     * [
     *   "z",
     *   "x"
     * ]
     *
     * Output: "zx"
     *
     */
    public String findOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }

        // a. Initalize the Graph
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for(String word : words) {
            for(char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<>());
            }
        }

        // b. Build the Graph
        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1]; //find of from characters from adjacent words

            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);

                if (parent != child) {
                    graph.get(parent).add(child); // put the child on parent's list
                    inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
                    break; // only the first different character between the two words will help us find the order
                }
            }
        }

        // c. Find All sources i.e, all vertices with 0 in-degrees
        Queue<Character> sources = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, add it to the sortedOrder and substract one from all it's childrens inDegree's
        // if a child's in-degree becomes zero, add it to the sources queue
        StringBuilder sortedOrder = new StringBuilder();
        while(!sources.isEmpty()) {
            Character vertex = sources.poll();
            sortedOrder.append(vertex);

            for(Character child : graph.get(vertex)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        // If sorted order doesn't contain all characters, there is a cyclic dependency between characters,
        // therefore, we will not be able to find the correct ordering of the characters
        if(sortedOrder.length() != inDegree.size()) {
            return "";
        }

        return sortedOrder.toString();
    }
}
