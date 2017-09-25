package com.oab;

import java.util.ArrayList;
import java.util.List;

public class Quick extends Operation {
    public static void sort(List<Integer> items) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> same = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        Integer chosenItem = items.get(items.size() / 2);
        for (Integer item : items) {
            if (item < chosenItem) {
                smaller.add(item);
            } else if (item > chosenItem) {
                larger.add(item);
            } else {
                same.add(item);
            }
        }

        sort(smaller);
        sort(larger);
        items.clear();
        items.addAll(smaller);
        items.addAll(same);
        items.addAll(larger);
    }
}
