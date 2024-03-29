package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueGeneralizedAbbreviations {

    /**
     *  Given a word, write a function to generate all of its unique generalized abbreviations.
     *
     *  Generalized abbreviation of a word can be generated by replacing each substring of the word by the count of characters in the substring. Take the example of “ab” which has four substrings: “”, “a”, “b”, and “ab”. After replacing these substrings in the actual word by the count of characters we get all the generalized abbreviations: “ab”, “1b”, “a1”, and “2”.
     *
     *  Example 1:
     *
     *  Input: "BAT"
     *  Output: "BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"
     *  Example 2:
     *
     *  Input: "code"
     *  Output: "code", "cod1", "co1e", "co2", "c1de", "c1d1", "c2e", "c3", "1ode", "1od1", "1o1e", "1o2",
     *  "2de", "2d1", "3e", "4"
     *
     *  Pablo's notes: First, this follows the Parentheses pattern (Generate Parentheses exercise)
     *  The key here is to notice that you have two options at every "state"
     *  1.- You abbreviate the letter
     *  2.- You add the letter to the word
     *
     *  Now, keep a counter of the abbreviated letter and a pointer index
     */
    public List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();

        Queue<Abbreviation> queue = new LinkedList<>();
        queue.offer(new Abbreviation("", 0, 0));

        while(!queue.isEmpty()) {
            Abbreviation current = queue.poll();

            if(current.index == word.length()) {
                result.add(current.str + (current.abbrCount == 0 ? "" : String.valueOf(current.abbrCount)));
                continue;
            }

            // option 1: We abbreviate this letter
            queue.offer(new Abbreviation(current.str, current.abbrCount + 1, current.index + 1));
            // option 2: we make it a work
            char letter = word.charAt(current.index);
            String abbreviatedWord = current.str + (current.abbrCount == 0 ? "" : String.valueOf(current.abbrCount)) + letter;
            queue.offer(new Abbreviation(abbreviatedWord, 0, current.index + 1));
        }

        return result;
    }

    private class Abbreviation {
        String str;
        int abbrCount;
        int index;

        public Abbreviation(String str, int abbrCount, int index) {
            this.str = str;
            this.abbrCount = abbrCount;
            this.index = index;
        }
    }
}
