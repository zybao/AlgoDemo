package com.oab.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Have you met this question in a real interview? Yes
 Example
 For example,
 If n = 4 and k = 2, a solution is:
 [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 */
public class Combination {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combo = new ArrayList<>();
        dfs(result, combo, 1, n, k);
        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> combo, int pos, int n, int k) {
        if (combo.size() == k) {
            result.add(new ArrayList<>(combo));
        } else if (combo.size() > k || pos > n) {
            return;
        }

        for (int i = pos; i <= n; i++) {
            combo.add(i);
            dfs(result, combo, i + 1, n, k);
            combo.remove(combo.size() - 1);
        }
    }
}
