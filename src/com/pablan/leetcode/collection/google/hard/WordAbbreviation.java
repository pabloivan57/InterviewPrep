package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordAbbreviation {

    /**
     *  Given an array of n distinct non-empty strings, you need to generate minimal possible
     *  abbreviations for every word following rules below.
     *
     * Begin with the first character and then the number of characters abbreviated,
     * which followed by the last character.
     * If there are any conflict, that is more than one words share the same abbreviation,
     * a longer prefix is used instead of only the first character until making the map from word
     * to abbreviation become unique. In other words, a final abbreviation cannot map to more than one
     * original words.
     * If the abbreviation doesn't make the word shorter, then keep it as original.
     * Example:
     *
     * Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
     * Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
     *
     * Pablo's notes: This explanation is actually pretty good from leetcode:
     *
     * For example, let's say we have "aabaaa", "aacaaa", "aacdaa",
     * then we start with "a4a", "a4a", "a4a". Since these are duplicated,
     * we lengthen them to "aa3a", "aa3a", "aa3a". They are still duplicated,
     * so we lengthen them to "aab2a", "aac2a", "aac2a". The last two are still duplicated,
     * so we lengthen them to "aacaaa", "aacdaa".
     *
     * Throughout this process,
     * we were tracking an index prefix[i] which tells us for work i, which index are you suppressing
     * for example: prefix[1] = 3 would mean for word aacdaa = aacd1a
     *
     * The real way of resolving this is by resolving words with multiple keywords using a Trie
     * Here is an example:
     *
     * like god interval internal me internet "interval", "intension", "face", "intrusion"
     *
     * With keywords now is
     *
     * l2e od i6l me i6t i7n f2e
     *         |              |
     *         |              |
     *         v              v
     *       interval      intension
     *       internal      intrusion
     *
     * the ones that repeat we put them in a Trie and at each node keep the number of paths
     * going through it
     *
     *          i +2
     *          n +2
     *          t +2
     *          e +2
     *          r +2
     *     n +1       v +1
     * -----------------------
     *     a +1       a +1
     *     l +1       l +1
     *
     * The cutoff point for each keyword is the very first node that is unique (only has 1 path going through it)
     *
     * the above 16l therefore becomes
     * intern1l  and interv1l --> But because the problem tells you to don't change if you have 3 characters then
     * they stay the same
     * internal and interval
     **/
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<String>> groupings = new HashMap<>();

        for(int i = 0; i < dict.size(); i++) {
            String word = dict.get(i);
            String abbreviation = createAbbreviation(word, 1);

            if(!groupings.containsKey(abbreviation)) {
                groupings.put(abbreviation, new ArrayList<>());
            }

            groupings.get(abbreviation).add(word);
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : groupings.entrySet()) {
            List<String> possibilities = entry.getValue();
            if(possibilities.size() == 1) {
                result.add(possibilities.get(0));
                continue;
            }

            List<String> resolvedPossibilities = resolve(possibilities);
            result.addAll(resolvedPossibilities);
        }

        return result;
    }

    private List<String> resolve(List<String> words) {
        // Step 1: Create Trie with word
        // For each word find the node where it has just one
        WordTrieNode root = new WordTrieNode();

        // Add words to Trie
        for(String word : words) {
            WordTrieNode current = root;
            char[] letters = word.toCharArray();

            for(int i = 0; i < word.length(); i++) {
                if(current.children[letters[i] - 'a'] == null) {
                    current.children[letters[i] - 'a'] = new WordTrieNode();
                }
                current = current.children[letters[i] - 'a'];
                current.pathCount++;
            }
        }

        List<String> result = new ArrayList<>();
        // find the very first one that has path count 1
        for(String word : words) {
            int levelSize = 0;
            WordTrieNode current = root;
            char[] letters = word.toCharArray();
            for(int i = 0; i < word.length(); i++){
                current = current.children[letters[i] - 'a'];
                levelSize++;

                // Check if we are missing 3 letters
                if(levelSize >= word.length() - 2) {
                    result.add(word);
                    break;
                }

                if(current.pathCount == 1) {
                    result.add(createAbbreviation(word, levelSize));
                    break;
                }
            }
        }

        return result;
    }

    private class WordTrieNode {
        WordTrieNode[] children;
        int pathCount;

        public WordTrieNode() {
            this.children = new WordTrieNode[26];
            pathCount = 0;
        }
    }

    private String createAbbreviation(String word, int indexStart) {
        if(word.length() <= 3) {
            return word;
        }

        StringBuilder abbreviation = new StringBuilder();
        abbreviation.append(word.substring(0, indexStart));
        abbreviation.append(word.length() - indexStart - 1);
        abbreviation.append(word.substring(word.length() - 2, word.length() - 1));

        return abbreviation.toString();
    }

    public List<String> wordsAbbreviationDumb(List<String> dict) {
        int[] prefix = new int[dict.size()];
        String[] answer = new String[dict.size()];

        for(int i = 0; i < prefix.length; i++) {
            prefix[i] = 1;
            answer[i] = createPrefix(dict.get(i), prefix[i]);
        }

        for(int i = 0; i < prefix.length; i++) {
            while(true) {
                Set<Integer> dupes = new HashSet<>();
                for (int j = i + 1; j < prefix.length; j++) {
                    if (answer[i].equals(answer[j])) {
                        dupes.add(j);
                    }
                }

                // No duplicates found, break
                if(dupes.isEmpty()) {
                    break;
                }

                // the algorithm calls to expand them all... this maybe probably not needed, but some edge
                // cases might break
                dupes.add(i);

                // create new prefixes for dupes
                for(Integer dupeIndex : dupes) {
                    answer[dupeIndex] = createPrefix(dict.get(dupeIndex), ++prefix[dupeIndex]);
                }
            }
        }

        return Arrays.asList(answer);
    }

    private String createPrefix(String word, int index) {
        // If word is 3 characters or less then no point on making prefix 'aoe' == 'a1e'. same size,
        // and 'ao' cannot be prefixed
        if(word.length() <= 3) {
            return word;
        }

        StringBuilder result = new StringBuilder();
        result.append(word.substring(0, index));
        result.append(word.length() - 1 - index);
        result.append(word.charAt(word.length() - 1));

        return result.toString();
    }
}
