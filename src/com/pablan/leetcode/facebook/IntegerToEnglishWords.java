package com.pablan.leetcode.facebook;

import java.util.LinkedList;
import java.util.StringJoiner;

public class IntegerToEnglishWords {

    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] chunks = new String[] {"", "Thousand", "Million", "Billion"}; // this is inverted because for method 2
    // we start from the back of the number

    /**
     * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
     *
     * Example 1:
     *
     * Input: 123
     * Output: "One Hundred Twenty Three"
     * Example 2:
     *
     * Input: 12345
     * Output: "Twelve Thousand Three Hundred Forty Five"
     *
     * @param num
     * @return
     */
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        return helper(num);
    }

    private String helper(int num) {
        String result;
        if(num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num / 100) + "Hundred" + helper(num % 100);
        else if (num < 1000000) result = helper(num / 1000) + "Thousand" + helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }

    public String numberToWordsTwo(int num) {
        if(num == 0) return "Zero";

        LinkedList<String> parts = new LinkedList<>();
        int chunkCount = 0;

        while(num > 0) {
            if(num % 1000 != 0) { // if it's 0 then you would  be transforming 000, there is no point
                String chunk = convertChunk(num / 100) + " " + chunks[chunkCount++];
                parts.addFirst(chunk);
            }
        }

        return String.join(" ", parts);
    }

    private String convertChunk(int number) {
        LinkedList<String> parts = new LinkedList<>();
        /* Convert hundreds */
        if(number >= 100) {
            parts.addLast(belowTen[number / 100]);
            number = number / 100;
        }

        /* Convert tend */
        if(number >= 10) {
            parts.addLast(belowHundred[number / 10]);
            number = number / 10;
        }

        if(number >= 1 && number <= 9) {
            parts.addLast(belowTen[number]);
        }

        return String.join(" ", parts);
    }
}
