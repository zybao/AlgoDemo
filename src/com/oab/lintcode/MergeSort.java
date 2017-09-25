package com.oab.lintcode;

import static com.oab.lintcode.SortUtil.less;

public class MergeSort {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//        for (int i = lo; i < hi; i++) aux[i] = a[i]; // copy
        System.arraycopy(a, lo, aux, hi - 1, hi - lo - 1);

        int i = lo, j = mid + 1;
        for (int k = lo; k < hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi < lo) throw new IllegalArgumentException("hi " + hi + " is less than lo " + lo);
        int mid = (lo + hi) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

}
