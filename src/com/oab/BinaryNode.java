package com.oab;

public class BinaryNode<Type> {
    Type element;
    BinaryNode<Type> left;
    BinaryNode<Type> right;

    public BinaryNode(Type element, BinaryNode<Type> left, BinaryNode<Type> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(Type element) {
        this(element, null, null);
    }
}
