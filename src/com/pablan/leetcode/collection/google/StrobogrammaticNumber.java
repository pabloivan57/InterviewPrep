package com.pablan.leetcode.collection.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrobogrammaticNumber {

    /**
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     *
     * Find all strobogrammatic numbers that are of length = n.
     *
     * Example:
     *
     * Input:  n = 2
     * Output: ["11","69","88","96"]
     *
     * Pablo's notes: This is a tricky question, but it helps if they tell you that
     * n = 0 > ""
     * n = 1 > 0 1 8
     * n = 2 > 11 69 88 96
     *
     * Because now... we you start going deeper you find a pattern
     *
     * if n = 1,  0   1   8
     * if n = 2,              11    88     69     96
     * if n = 3, 101 111 181
     *           808 818 888
     *           609 619 689
     *           906 916 986
     * if n = 4,             1111  1881   1691   1961   1001
     *                       8118  8888   8698   8968   8008
     *                       6119  6889   6699   6969   6009
     *                       9116  9886   9696   9966   9006
     *
     * Notice how 3 is generated from 1 and 4 from 2
     *
     * This basically means. I have 4 ways of adding strobogramattic to boths sides of a number
     * We drop 0 because 0 on the left doesn't add up on the left
     * 1 _ 1
     * 6 _ 9
     * 9 _ 6
     * 8 _ 8
     *
     * you will always have two numbers .. if you want odd result then you add odd numbers in the middle
     * if you want even then you add even numbers in the middle
     * if you want 3? 2 + 1 will do
     * if you want 4? 2 + 2 will do
     * if you want 5? 2 + 3 will do
     *
     * and that also gives you the recursion
     * strogromattic(n) = 1 + strobrogramttic(n - 2) + 1 or 6 + strobogramatic(n - 2) + 9... etc
     *
     * Basically you go recurisve, you have case 0 and case 1 and case 2... go on
     */
    public List<String> findStrobogrammatic(int n) {
        return recurse(n);
    }

    private List<String> recurse(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {
            result.add("");
            return result;
        }

        if(n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");
            return result;
        }

        List<String> numbers = recurse(n - 2);
        for(String number : numbers) {
            result.add("1" + number + "1");
            result.add("6" + number + "9");
            result.add("8" + number + "8");
            result.add("9" + number + "6");
        }

        return result;
    }
}
