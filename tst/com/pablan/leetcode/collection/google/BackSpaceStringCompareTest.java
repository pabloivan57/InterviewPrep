package com.pablan.leetcode.collection.google;

import com.pablan.leetcode.google.BackspaceStringCompare;
import org.junit.Test;

public class BackSpaceStringCompareTest {

    @Test
    public void test() {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        //System.out.println(backspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceStringCompare.backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceStringCompare.backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceStringCompare.backspaceCompare("a#c", "b"));
    }
}
