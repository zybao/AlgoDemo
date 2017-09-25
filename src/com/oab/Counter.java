package com.oab;

/**
 * Created by bao on 2017/5/31.
 */
public class Counter {
    private String id;
    private static int count = 0;

    public Counter(String id) {
        this.id = id;
        count++;
    }

    public void increment() {

    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                '}';
    }
}
