package com.pablan.grokking.patterns.topological;

import org.junit.Test;

public class AlienDictionaryTest {

    @Test
    public void test() {
        String result = new AlienDictionary().findOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = new AlienDictionary().findOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = new AlienDictionary().findOrder(new String[] { "ywx", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);
    }
}
