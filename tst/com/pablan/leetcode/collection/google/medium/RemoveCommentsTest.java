package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class RemoveCommentsTest {

    @Test
    public void test() {
        RemoveComments removeComments = new RemoveComments();
        System.out.println(removeComments.removeComments(new String[] {"/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"}));
    }
}
