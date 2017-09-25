package com.oab;

public class Hash {
    static int a = 3, b = 42, p = 101, m = 9;

    public static void main(String[] args) {
        int arr[] = {10, 22, 37, 40, 52, 60, 70, 72, 75};
        for (int i : arr) {
            System.out.println(i + ": " + hash(i));
        }
    }

    public static int hash(int k) {
        return Math.floorMod(Math.floorMod(a * k + b, p), m);
    }
}
