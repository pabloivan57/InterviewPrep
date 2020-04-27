package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class HappyNumberTest {

    @Test
    public void test() {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.find(23)); // should be true
        // 23-> 13 -> 10 -> 1
        System.out.println(happyNumber.find(13)); // should be true
        // 13 -> 10 -> 1
        System.out.println(happyNumber.find(12)); // should be false
        // 12 -> 5 -> 25 -> 29 -> 85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
    }
}
