package com.oab;

public class Stack<T> {
    T top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T t) {
        this.top = t;
    }
}
