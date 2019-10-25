package com.pablan.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncodeDecodeStrings {

    /**
     * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
     *
     * Machine 1 (sender) has the function:
     *
     * string encode(vector<string> strs) {
     *   // ... your code
     *   return encoded_string;
     * }
     * Machine 2 (receiver) has the function:
     * vector<string> decode(string s) {
     *   //... your code
     *   return strs;
     * }
     * So Machine 1 does:
     *
     * string encoded_string = encode(strs);
     * and Machine 2 does:
     *
     * vector<string> strs2 = decode(encoded_string);
     * strs2 in Machine 2 should be the same as strs in Machine 1.
     *
     * Implement the encode and decode methods.
     */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str).append(";");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s  == null) {
            return Collections.emptyList();
        }

        String[] parts = s.split(";");

        return Arrays.asList(parts);
    }
}
