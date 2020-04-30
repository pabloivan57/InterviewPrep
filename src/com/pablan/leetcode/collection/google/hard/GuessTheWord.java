package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuessTheWord {

    private String key;

    /**
     *  This is the Master's API interface.
     *  You should not implement it, or speculate about its implementation
     *  interface Master {
     *      public int guess(String word) {}
     *  }
     *
     * This problem is an interactive problem new to the LeetCode platform.
     *
     * We are given a word list of unique words, each word is 6 letters long,
     * and one word in this list is chosen as secret.
     *
     * You may call master.guess(word) to guess a word.  The guessed word should have type string and must be from
     * the original list with 6 lowercase letters.
     *
     * This function returns an integer type, representing the number of exact matches (value and position) of your
     * guess to the secret word.  Also, if your guess is not in the given wordlist, it will return -1 instead.
     *
     * For each test case, you have 10 guesses to guess the word. At the end of any number of calls, if you have made
     * 10 or less calls to master.guess and at least one of these guesses was the secret, you pass the testcase.
     *
     * Besides the example test case below, there will be 5 additional test cases, each with 100 words in the word list.
     * The letters of each word in those testcases were chosen independently at random from 'a' to 'z',
     * such that every word in the given word lists is unique.
     *
     * Example 1:
     * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
     *
     * Explanation:
     *
     * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
     * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
     * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
     * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
     * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
     *
     * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
     * Note:  Any solutions that attempt to circumvent the judge will result in disqualification.
     *
     * Pablo's notes: The key in this algorithm is as follows
     * - Assumptions: we are guaranteed all words are same size
     * 1.- We pick a random word and guess it
     * 2.- With the number, we simply find all the words that have x matches. Why? because of the
     * way guess works (which just matches index by index) we are guaranteed the solution will have the x matches
     * from the solution. Now, think about this... it could match the x letters from the solution or 3 other letters,
     * it doesn't matter as long as all the keywords matching the letters from the solution are there. At this point
     * we just want to reduce the results set
     * 3.- Pick those words and change the word list to contains just those... In other words, override the list
     *
     * Improvements
     * 1.- Picking a word randomly works, but is not optimal? The way we improve this is by saying the following
     * "We want to pick a word that has the most commonalities with other words, because that will test multiple
     * potential guesses simultaneously, or at least the letters that are the most common in the set"
     * Note: This is minimax because of what it is trying to achieve. The solutions in leetcode are scary but this
     * is really what they mean with minimax
     * - We do that in two ways
     * 1) For each word, we count how many of the other words have 0 in common with it (no matches) and then pick the
     *    one with the least amount (O^2) complexity
     * 2) we come up with a scoring system. The scoring tells use the following
     *    "For a given word, how many times letter w[i] appears in the whole list? Ok, now add that to the amount
     *     of times letter w[i + 1] shows up and so on... That's the word score. Now, pick the one with the most score,
     *     or in other words (the most commonalities)"
     */
    public void findSecretWord(String[] wordlist, Master master) {
        int turns = 10;
        // 10 tries
        for(int i = 0; i < turns; i++) {
            // Step 1: calculate commonalities
            // 6 letters each keywords by 26 of the alphabet
            int[][] occurrences = new int[6][26];

            for(String word : wordlist) {
                for(int j = 0; j < 6; j++) {
                    char letter = word.charAt(j);
                    occurrences[j][letter - 'a']++;
                }
            }

            // Step 2 pick the word with the most commonalities
            String guess = wordlist[0]; // default
            int bestScore = 0;
            for(String word : wordlist) {
                int score = 0;
                for(int j = 0; j < 6; j++) {
                    char letter = word.charAt(j);
                    score += occurrences[j][letter - 'a'];
                }

                if(score > bestScore) {
                    guess = word;
                    bestScore = score;
                }
            }

            // Step 3 guess the word
            int matchCount = master.guess(guess);
            List<String> prunedWordList = new ArrayList<>();

            // Step 4 pick the words that match 'matches'
            for(String word : wordlist) {
                if(matches(guess, word) == matchCount) {
                    prunedWordList.add(word);
                }
            }

            // Step 5 override word list with 'pruned List'
            wordlist = prunedWordList.toArray(new String[0]);
        }
    }

    // Assumes word1, word2 are the same size
    private int matches(String word1, String word2) {
        int matches = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) == word2.charAt(0)) {
                matches++;
            }
        }
        return matches;
    }

    private static class Master {

        private String key;
        Map<Character, Integer> occurrences = new HashMap<>();

        public Master(String key) {
            this.key = key;
            char[] pattern = key.toCharArray();
            for(char character : pattern) {
                occurrences.put(character, occurrences.getOrDefault(character, 0) + 1);
            }
        }

        public int guess(String word) {
            int matches = 0;
            for(int i = 0; i < word.length(); i++) {
                if(key.charAt(i) == word.charAt(0)) {
                    matches++;
                }
            }

            return matches;
        }
    }
}
