package com.oab.lintcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoPointer {
    public static void main(String[] args) {

    }

    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
     * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
     * with x-axis forms a container, such that the container contains the most water.
     * <p>
     * Have you met this question in a real interview? Yes
     * Example
     * Given [1,3,2], the max area of the container is 2.
     * <p>
     * Note
     * You may not slant the container.
     *
     * @param heights
     * @return max water
     */
    public int containerWithMaxWater(int[] heights) {
        if (heights == null || heights.length < 2) return 0;

        int start = 0, end = heights.length - 1;
        int max = 0;
        while (start < end) {
            while (heights[start] <= heights[end] && start < end) {
                max = Math.max(max, (end - start) * heights[start]);
                start++;
            }

            while (heights[start] > heights[end] && start < end) {
                max = Math.max(max, (end - start) * heights[end]);
                end--;
            }
        }

        return max;
    }

    /**
     * Given a target number, a non-negative integer k and an integer array A sorted in ascending order,
     * find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target.
     * Otherwise, sorted in ascending order by number if the difference is same.
     * <p>
     * Example
     * Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
     * <p>
     * Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
     */
    public int[] kCloestNumbers(int[] num, int target, int k) {
        if (num == null || num.length == 0) return new int[0];
        int result[] = new int[k];

        int start = 0, end = num.length;
        while (start < end - 1) {
            int mid = (start + end) / 2;
            if (num[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            int startDiff = (start < 0) ? Integer.MAX_VALUE : Math.abs(num[start] - target);
            int endDiff = (end > num.length) ? Integer.MAX_VALUE : Math.abs(num[end] - target);
            if (startDiff <= endDiff) {
                result[i] = num[start];
                start--;
            } else {
                result[i] = num[end];
                end++;
            }
        }

        return result;

    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     */
    public int longestSubstringWithoutRepeatingCharacters(String str) {
        if (str == null || str.length() == 0) return 0;

        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        int size = str.length();
        int i = 0, j = 0, max = 0;
        while (j < size) {
            if (!set.contains(chars[j])) {
                set.add(chars[j++]);
                max = Math.max(max, j - i);
            } else {
                set.remove(chars[j++]);
            }
        }

        return max;
    }

    /**
     * Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number.
     * Please return the number of pairs.
     * <p>
     * Example
     * numbers=[2, 7, 11, 15], target=24
     * <p>
     * return 1
     */
    public int twoSumII(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;

        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        int count = 0;
        while (start < end) {
            if (arr[start] + arr[end] > target) {
                count += end - start;
                end--;
            } else {
                start++;
            }
        }

        return count;
    }

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * <p>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * Please note that your returned answers (both index1 and index2) are NOT zero-based.
     * <p>
     * Have you met this question in a real interview? Yes
     * Example
     * numbers=[2, 7, 11, 15], target=9
     * <p>
     * return [1, 2]
     * <p>
     * Note
     * You may assume that each input would have exactly one solution
     */
    public int[] twoSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return null;
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                result[0] = i + 1;
                result[1] = map.get(target - arr[i]) + 1;
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }

    /**
     * Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?
     * <p>
     * Have you met this question in a real interview? Yes
     * Example
     * Given array S = [3,4,6,7], return 3. They are:
     * <p>
     * [3,4,6]
     * [3,6,7]
     * [4,6,7]
     * Given array S = [4,4,4,4], return 4. They are:
     * <p>
     * [4(1),4(2),4(3)]
     * [4(1),4(2),4(4)]
     * [4(1),4(3),4(4)]
     * [4(2),4(3),4(4)]
     */
    public int triangleCount(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 2; i < arr.length; i++) {
            int start = 0, end = arr.length - 1;
            while (start < end) {
                if (arr[start] + arr[end] > arr[i]) {
                    count += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }

        return count;
    }

    /**
     * Given two array of integers(the first array is array A, the second array is array B),
     * now we are going to find a element in array A which is A[i], and another element in array B which is B[j],
     * so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.
     * <p>
     * Example
     * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
     */
    public int smallestDiff(int arrA[], int arrB[]) {
        if (arrA == null || arrB == null) return -1;

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int startA = 0;
        int startB = 0;
        int minDiff = Integer.MAX_VALUE;
        while (startA < arrA.length && startB < arrB.length) {
            if (arrA[startA] == arrB[startB]) {
                return 0;
            } else if (arrA[startA] > arrB[startB]) {
                minDiff = Math.min(minDiff, arrA[startA] - arrB[startB]);
            } else {
                minDiff = Math.min(minDiff, arrB[startB] - arrA[startA]);
            }
        }

        return minDiff;
    }
}
