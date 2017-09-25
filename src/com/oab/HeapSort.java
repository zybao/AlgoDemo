package com.oab;

public class HeapSort {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <T extends Comparable<? super T>> void precDown(T[] a, int i, int n) {
        int child;
        T tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }

            if (tmp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }

    public static <T extends Comparable<? super T>> void heapSort(T[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            precDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {

        }
    }
}
