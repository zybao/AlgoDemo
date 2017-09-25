package com.oab;

public class Merge {
    private static Comparable[] aux;
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];

    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;
        sort(a, low, high);
        sort(a, mid + 1, high);
//        sort(a, low, );
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = high;
        for (int k = low; k <=high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
        }

    }
}
