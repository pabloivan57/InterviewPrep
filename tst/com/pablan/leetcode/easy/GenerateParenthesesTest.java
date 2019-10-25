package com.pablan.leetcode.easy;

import org.junit.Test;

import java.util.List;

public class GenerateParenthesesTest {

    @Test
    public void test() {
        GenerateParentheses generateParentheses = new GenerateParentheses();

        List<String> result = generateParentheses.generateParentheses(3);

        System.out.println(result);
    }
}
