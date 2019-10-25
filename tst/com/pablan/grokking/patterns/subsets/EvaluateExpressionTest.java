package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

import java.util.List;

public class EvaluateExpressionTest {

    @Test
    public void test() {
        List<Integer> result = new EvaluateExpression().diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = new EvaluateExpression().diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
