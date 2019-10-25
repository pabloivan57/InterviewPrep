package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class HappyNumberTest {

    @Test
    public void test() {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.find(23));
    }
}
