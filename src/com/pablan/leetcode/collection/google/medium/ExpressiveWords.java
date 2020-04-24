package com.pablan.leetcode.collection.google.medium;

public class ExpressiveWords {

    /**
     * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".
     * In these strings like "heeellooo",
     * we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
     *
     * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of
     * applications of the following extension operation: choose a group consisting of characters c,
     * and add some number of characters c to the group so that the size of the group is 3 or more.
     *
     * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo",
     * but we cannot get "helloo" since the group "oo" has size less than 3.
     * Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo",
     * then the query word "hello" would be stretchy because of these two extension operations:
     * query = "hello" -> "hellooo" -> "helllllooo" = S.
     *
     * Given a list of query words, return the number of words that are stretchy
     *
     * Example:
     * Input:
     * S = "heeellooo"
     * words = ["hello", "hi", "helo"]
     * Output: 1
     * Explanation:
     * We can extend "e" and "o" in the word "hello" to get "heeellooo".
     * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
     *
     * Pablo's notes: First, the problem is not that clear
     * They are asking to identify which on from those words can be stretched out to match S
     */
    public int expressiveWords(String S, String[] words) {
        int stretchyWords = 0;

        for(int i = 0; i < words.length; i++) {
            if(isStretchy(S, words[i])) {
                stretchyWords++;
            }
        }

        return stretchyWords;
    }

    private boolean isStretchy(String s, String word) {
        int p1 = 0;
        int p2 = 0;

        // This && is important, for example
        // helloo
        // heeee
        // if you do p1 < s || p2 < word, you will check l against null
        while(p1 < s.length() && p2 < word.length()) {
            char char1 = s.charAt(p1);
            char char2 = word.charAt(p2);

            if(char1 != char2) {
                return false; // Cannot be stretchy by definition
            }

            int len1 = findRepeatedLetterLength(p1, s);
            int len2 = findRepeatedLetterLength(p2, word);

            if(len1 < 3 && len1 != len2) {
                // this cannot be stretchy as well, take this for example
                // hello
                // helllo -> in this case we can't match ll with lll
                return false;
            } else if(len1 >= 3 && len2 > len1) {
                // Similar case we have more letters on the second word than the first one, we can't make it stretchy
                return false;
            }

            p1 += len1;
            p2 += len2;
        }

        return p1 == s.length() && p2 == word.length();
    }

    private int findRepeatedLetterLength(int index, String word) {
        int count = 0;
        char character = word.charAt(index);
        int p1 = index;

        while(p1 < word.length()) {
            if(word.charAt(p1++) == character) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
