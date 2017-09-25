package com.oab;

public class AvlNode<AnyType extends Comparable> {
    AnyType element;
    AvlNode<AnyType> left;
    AvlNode<AnyType> right;
    int height;

    public AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public AvlNode(AnyType theElement) {
        this(theElement, null, null);
    }

    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<AnyType>(x);
        }

        int compare = x.compareTo(t.element);
        if (compare < 0) {
            t.left = insert(x, t.left);
        } else if (compare > 0) {
            t.right = insert(x, t.right);
        } else {

        }

        return balance(t);
    }

    public static final int ALLOWED_INBALANCE = 1;

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) return t;
        if (height(t.left) - height(t.right) > ALLOWED_INBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_INBALANCE){
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> t) {
        return null;
    }

    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> t) {
        return null;
    }
}
