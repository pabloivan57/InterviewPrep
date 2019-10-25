package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {

    public List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for(int i = 0; i < str.length(); i++) {
            if(!Character.isLetter(str.charAt(i))) {
                continue;
            }

            int n = permutations.size();
            for(int j = 0; j < n; j++) {
               String oldPerm = permutations.get(j);
               String newPerm = oldPerm.replace(oldPerm.charAt(i), Character.toUpperCase(oldPerm.charAt(i)));
               permutations.add(newPerm);
            }
        }

        return permutations;
    }
}
