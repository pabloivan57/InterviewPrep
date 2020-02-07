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
     * Pablo's notes: Keep in mind this
     *
     * StrobogrammaticNumber of length = 0
     * ""
     * StrobogrammaticNumber of length = 1
     * 1, 6, 9, 8
     *
     * with this you can infer a way of generating all ways
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
