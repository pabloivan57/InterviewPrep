package com.pablan.grokking.patterns.subsets;

public class ParenthesesString {
    String str;
    int openCount;
    int closeCount;

    public ParenthesesString(String s, int openCount, int closeCount) {
        str = s;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}
