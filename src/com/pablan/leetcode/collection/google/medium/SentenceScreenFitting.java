package com.pablan.leetcode.collection.google.medium;

public class SentenceScreenFitting {

    /**
     * Given a rows x cols screen and a sentence represented by a list of non-empty words,
     * find how many times the given sentence can be fitted on the screen.
     *
     * Note:
     *
     * A word cannot be split into two lines.
     * The order of words in the sentence must remain unchanged.
     * Two consecutive words in a line must be separated by a single space.
     * Total words in the sentence won't exceed 100.
     * Length of each word is greater than 0 and won't exceed 10.
     * 1 ≤ rows, cols ≤ 20,000.
     * Example 1:
     *
     * Input:
     * rows = 2, cols = 8, sentence = ["hello", "world"]
     *
     * Output:
     * 1
     *
     * Explanation:
     * hello---
     * world---
     *
     * The character '-' signifies an empty space on the screen.
     * Example 2:
     *
     * Input:
     * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
     *
     * Output:
     * 2
     *
     * Explanation:
     * a-bcd-
     * e-a---
     * bcd-e-
     *
     * The character '-' signifies an empty space on the screen.
     * Example 3:
     *
     * Input:
     * rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
     *
     * Output:
     * 1
     *
     * Explanation:
     * I-had
     * apple
     * pie-I
     * had--
     *
     * The character '-' signifies an empty space on the screen.
     *
     * Pablo's notes: Imagine an infinite sentence that are concatenated by words from the given sentence, infiStr. We want to cut the infiStr properly and put a piece at each row of the screen.
     * We maintain a pointer ptr. The ptr points to a position at infiStr, where next row will start. Cutting the infiStr and putting a piece at a row can be simulated as advancing the pointer by cols positions.
     * After advancing the pointer, if ptr points to a space, it means the piece can fit in row perfectly. If ptr points to the middle of a word, we must retreat the pointer to the beginning of the word, because a word cannot be split into two lines.
     *
     * IN THE CODE, keep in mind you can fit a sentence multiple times... therefore
     * start could potentially go beyond (s.length). That's why we do sIndex % length
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int sentenceLength = s.length();
        int start = 0;

        for(int i = 0; i < rows; i++) {
            start += cols;
            if(s.charAt(start % sentenceLength) == ' ') {
                start++;
            } else {
                // we weren't able to fit in a single row. Backup until after the first ' '
                while(start > 0 && s.charAt((i - 1) % sentenceLength) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();
    }


    public int wordsTypingLame(String[] sentence, int rows, int cols) {
        int size = sentence.length;

        int result = 0;
        int counter = size;
        int currentRow = 0;
        int currentCol = 0;

        int s1 = 0;

        while(currentRow < rows) {
            while(currentCol < cols) {
               int sentenceSize = sentence[s1].length();
               if(currentCol + sentenceSize < cols) {
                   counter--;
                   currentCol = currentCol + sentenceSize + 1; // between cols I need 1 space
                   s1 = (s1 + 1) % size;
                   if(counter == 0) {
                       result++;
                       counter = size;
                   }
               } else {
                   currentCol += sentenceSize;
               }
            }
            currentRow++;
            currentCol = 0;
        }

        return result;
    }
}
