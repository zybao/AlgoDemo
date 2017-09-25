package com.oab.lintcode;

public class BinarySearch {
    public static int[] arr = {12, 14, 14, 15, 34, 56, -1, 0, 4, 12, 12, 12};

    public static void main(String[] args) {
        System.out.println("find min 1: " + findMinInRotatedArray(arr));
        System.out.println("find min 2: " + findMinInRotatedArrayII(arr));
    }

    /**
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * Have you met this question in a real interview? Yes
     * Example
     * Given [4, 5, 6, 7, 0, 1, 2] return 0
     */
    public static int findMinInRotatedArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= arr[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[start] < arr[end]) {
            return arr[start];
        } else {
            return arr[end];
        }
    }

    public static int findMinInRotatedArrayII(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[end]) {
                start = mid;
            } else if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                end--;
            }
        }

        if (arr[start] < arr[end]) {
            return arr[start];
        } else {
            return arr[end];
        }
    }

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix,
     * return the occurrence of it.
     * This matrix has the following properties:
     * * Integers in each row are sorted from left to right.
     * * Integers in each column are sorted from up to bottom.
     * * No duplicate integers in each row or column.
     * <p>
     * Have you met this question in a real interview? Yes
     * Example
     * Consider the following matrix:
     * <p>
     * [
     * <p>
     * [1, 3, 5, 7],
     * <p>
     * [2, 4, 7, 8],
     * <p>
     * [3, 5, 9, 10]
     * <p>
     * ]
     * <p>
     * Given target = 3, return 2.
     */
    public int search2DMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return 0;
        if (matrix[0] == null || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int x = n - 1;
        int y = 0;
        int count = 0;
        while (x > 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }

        return count;
    }
}
