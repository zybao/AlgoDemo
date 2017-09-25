package com.oab;

public class RedBlackNode<T> {
    public static final int BLACK = 1, RED = BLACK >> 1;
    T element;
    RedBlackNode<T> left;
    RedBlackNode<T> right;
    int color;

    public RedBlackNode(T element, RedBlackNode<T> left, RedBlackNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.color = BLACK;
    }

    public RedBlackNode(T theElement) {
        this(theElement, null, null);
    }
}
