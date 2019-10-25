package com.pablan.leetcode.easy;

import java.util.*;

public class ValidParentheses {

    Map<Character, Character> mappings = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    //Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Note that an empty string is also considered valid.
    //Input: "()"
    //Output: true
    //Input: "()[]{}"
    //Output: true
    //Input: "(]"
    //Output: false
    //Input: "([)]"
    //Output: false
    //Input: "{[]}"
    //Output: true
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if(mappings.containsKey(character)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if(topElement != mappings.get(character)) {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }

        return stack.isEmpty();
    }
}
