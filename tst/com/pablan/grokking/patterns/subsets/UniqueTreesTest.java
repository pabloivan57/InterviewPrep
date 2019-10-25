package com.pablan.grokking.patterns.subsets;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

import java.util.List;

public class UniqueTreesTest {

    @Test
    public void test() {
        List<TreeNode> result = new UniqueTrees().findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
