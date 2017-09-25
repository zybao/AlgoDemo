package com.oab;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 90, -10, 32, 13, 98};
        quickSort(arr, 1, arr.length - 1);
        for (int i = 1; i < arr.length - 1; i++) {
            System.out.println(i + ": " + arr[i]);
        }
    }

    public static int partition(int[] arr, int first, int last) {
        int pivot = arr[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && arr[low] <= pivot) low++;
            while (low <= high && arr[high] > pivot) high--;
            if (high > low) {
                arr[high] += arr[low];
                arr[low] = arr[high] - arr[low];
                arr[high] -= arr[low];
            }
        }

        while (high > first && arr[high] >= pivot) high--;

        if (pivot > arr[high]) {
            arr[first] = arr[high];
            arr[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] -= arr[j];
    }
}
