package com.pablan.leetcode.collection.google;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {

    /**
     *  Given a set of words (without duplicates), find all word squares you can build from them.
     *
     * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
     *
     * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
     *
     * b a l l
     * a r e a
     * l e a d
     * l a d y
     * Note:
     *
     * There are at least 1 and at most 1000 words.
     * All words will have the exact same length.
     * Word length is at least 1 and at most 5.
     * Each word contains only lowercase English alphabet a-z.
     * Example 1:
     *
     * Input:
     * ["area","lead","wall","lady","ball"]
     *
     * Output:
     * [
     *   [ "wall",
     *     "area",
     *     "lead",
     *     "lady"
     *   ],
     *   [ "ball",
     *     "area",
     *     "lead",
     *     "lady"
     *   ]
     * ]
     *
     * Explanation:
     * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
     *
     * Pablo's notes: The trick here is symetric property, notice how elements on the diagonal are symetrical.
     * w a l l -->  w a l l
     * a (a)        a r e a --> only option, now find words with l e
     * l            l e (l)
     * l            l a
     *
     * The prefix is obtained with each word at step i, for example above. We know the next word step 3 should come
     * w a (l) l, a r (e) a == le
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            List<String> wordList = new ArrayList<>();
            // pick a word
            wordList.add(words[i]);
            backtrack(1, words, wordList, result);
        }

        return result;
    }

    public void backtrack(int step, String[] words, List<String> wordList, List<List<String>> result) {
        // step is 0-based, is skipping first word with would be grid[0, 0]
        if(step == words.length - 1) {
            result.add(wordList);
            return;
        }

        // Find prefix at step n
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < wordList.size(); i++) {
            prefix.append(wordList.get(i).charAt(step));
        }

        List<String> candidates = findWordsWithPrefix(prefix.toString(), words);

        for(int i = 0; i < candidates.size(); i++) {
            // Add the word
            wordList.add(candidates.get(i));
            backtrack(step + 1, words, wordList, result);

            // backtrack
            wordList.remove(wordList.size() - 1);
        }
    }

    // You can optimize this by creating a hashmap with prefixes
    public List<String> findWordsWithPrefix(String prefix, String[] words) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].startsWith(prefix)) {
                result.add(words[i]);
            }
        }
        return result;
    }
}
