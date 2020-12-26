package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

public class UniqueGeneralizedAbbreviationsTest {

    @Test
    public void test() {
        UniqueGeneralizedAbbreviations uniqueGeneralizedAbbreviations = new UniqueGeneralizedAbbreviations();
        System.out.println(uniqueGeneralizedAbbreviations.generateGeneralizedAbbreviation("BAT"));
    }
}
