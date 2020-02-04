package com.pablan.leetcode.collection.google;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

    /**
     * Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
     * Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
     *
     * Furthermore, you may assume that the original data does not
     * contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
     *
     * Examples:
     *
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */
    public String decodeString(String s) {
        Stack<DecodeComponent> components = new Stack<>();

        int end = s.length() - 1;
        while(end >= 0) {
            StringBuilder buffer = new StringBuilder();
            while(s.charAt(end) != ']') {
                buffer.append(s.charAt(end));
                end--;
            }
            components.push(new DecodeComponent(0, buffer.reverse().toString()));
            buffer = new StringBuilder();
            end--;
            while(s.charAt(end) != '[') {
                buffer.append(s.charAt(end));
                end--;
            }
            end--; // skip '['
            int repeat = Character.getNumericValue(s.charAt(end--)); // get number and advance
            components.push(new DecodeComponent(repeat, buffer.reverse().toString()));
        }

        StringBuilder buffer = new StringBuilder();
        while(!components.isEmpty()) {
             DecodeComponent component = components.pop();
             for(int i = 0; i < component.number; i++) {
                 buffer.append(component.component);
             }
        }

        return buffer.toString();
    }

    public String decodeStringElegant(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        return helper(queue);
    }

    public String helper(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c= queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private class DecodeComponent {
        int number;
        String component;

        public DecodeComponent(int number, String component) {
            this.number = number;
            this.component = component;
        }
    }
}
