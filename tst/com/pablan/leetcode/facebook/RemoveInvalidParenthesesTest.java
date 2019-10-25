package com.pablan.leetcode.facebook;

import org.junit.Test;

public class RemoveInvalidParenthesesTest {

    @Test
    public void test() {
        System.out.println(new RemoveInvalidParentheses().removePablanInefficient("()())()"));
        System.out.println(new RemoveInvalidParentheses().removePablanInefficient("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removePablanInefficient(")("));
    }
}
