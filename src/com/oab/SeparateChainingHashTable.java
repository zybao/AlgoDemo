package com.oab;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<T> {
    public static final int DEFAULT_SIZE = 101;
    private List<T>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new List[1];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }

        currentSize = 0;
    }

    private int myhash(T t) {
        int hashVal = t.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }

        return hashVal;
    }
}
