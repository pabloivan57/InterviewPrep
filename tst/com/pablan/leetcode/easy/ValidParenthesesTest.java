package com.pablan.leetcode.easy;

import org.junit.Test;

public class ValidParenthesesTest {

    @Test
    public void test() {
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
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
    }
}
