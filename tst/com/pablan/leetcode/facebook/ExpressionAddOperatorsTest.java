package com.pablan.leetcode.facebook;

import org.junit.Test;

import java.util.List;

public class ExpressionAddOperatorsTest {

    @Test
    public void test() {
        List<String> result = new ExpressionAddOperators().addOperators("123", 6);
        System.out.println(result);
        /*result = new ExpressionAddOperators().addOperators("232", 8);
        System.out.println(result);
        result = new ExpressionAddOperators().addOperators("105", 5);
        System.out.println(result);
        result = new ExpressionAddOperators().addOperators("00", 0);
        System.out.println(result);
        result = new ExpressionAddOperators().addOperators("3456237490", 9191);
        System.out.println(result);*/
    }
}
