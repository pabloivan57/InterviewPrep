package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

import java.util.List;

public class GenerateParenthesesTest {

    @Test
    public void test() {
        List<String> result = new GenerateParentheses().generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = new GenerateParentheses().generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
