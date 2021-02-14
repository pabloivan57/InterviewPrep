package com.pablan.leetcode.medium;

import java.util.ArrayList;
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
     *
     * Pablo's Notes: Google likes to ask how could you optimize this algorithm,
     * there is a way by following http mechanism. While encoding you transform the chunk size
     * into a 4byte number and append to the encoded string. For example
     *
     * "aloha" "faa" "enc"
     *
     * "0005aloha0003faa0003enc"
     *
     * To decode you just read every 4 bit sizes and then move the pointer accordingly
     *
     * Another way (if you don't want to fuck up with bytes) is to encode with the size of the string
     * before the string. This is more efficient in the sense that you don't have to open a stream
     * to read the next character every single time but you do it once at a chunk.
     *
     * basically the words above would be
     * 5#aloha3#faa#3enc. --> Why the '#' as special character? Well that's because in the case
     * a word start with a number then the word would be encoded incorrectly
     * 123aloha woud be like 8123aloha and could be misread
     */
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int pointer = 0;
        int startWord = 0;
        while(s != null && pointer < s.length()) {
            // read word by word
            while(s.charAt(pointer)!= '#') {
                pointer++;
            }

            // compute length
            String lengthString = s.substring(startWord, pointer); // non inclusive
            int length = Integer.valueOf(lengthString);

            String word = s.substring(pointer + 1, pointer + 1 + length);
            result.add(word);

            pointer = pointer + 1 + length;
            startWord = pointer;
        }

        return result;
    }
}
