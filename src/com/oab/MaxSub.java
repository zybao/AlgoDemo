package com.oab;

/**
 * Created by bao on 2017/6/12.
 */
public class MaxSub {
    public static int maxSubSum2(int[] arr) {
        int maxSum = 0;
        for (int anArr : arr) {
            int thisSum = 0;
            for (int anArr1 : arr) {
                thisSum += anArr1;
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }
}
