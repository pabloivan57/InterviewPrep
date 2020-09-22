package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

import java.util.List;

public class AutocompleteSystemTest {

    @Test
    public void test() {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(new String[] {"i love you", "island","ironman", "i love leetcode"}, new int[] {5,3,2,2});
        List<String> result = autocompleteSystem.input('i'); // should be "i love you","island", "i love leetcode"
        result  = autocompleteSystem.input(' ');  // "i love you","i love leetcode"s
    }
}
