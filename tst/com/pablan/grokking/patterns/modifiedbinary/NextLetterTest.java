package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class NextLetterTest {

    @Test
    public void test() {
        NextLetter nextLetter = new NextLetter();
        System.out.println(nextLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'f')); // should be 'h'
        System.out.println(nextLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'b')); // should be 'c'
        System.out.println(nextLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'm')); // should be 'a'
        System.out.println(nextLetter.searchNextLetter(new char[] {'a', 'c', 'f', 'h'}, 'h')); // should be 'a'
    }
}
