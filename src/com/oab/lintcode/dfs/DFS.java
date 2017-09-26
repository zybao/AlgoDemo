package com.oab.lintcode.dfs;

import java.util.List;

public class DFS {
    public static void main(String[] args) {
        print(Combination.combine(10,8));
    }

    public static void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
