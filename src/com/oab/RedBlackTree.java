package com.oab;

import java.util.concurrent.BlockingDeque;

public class RedBlackTree<T extends Comparable<? super T>> {
    private RedBlackNode<T> header;
    private RedBlackNode<T> nullNode;

    public RedBlackTree() {
        nullNode = new RedBlackNode<T>(null);
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode<T>(null);
        header.left = header.right = nullNode;
    }

    private RedBlackNode<T> rotate(T item, RedBlackNode<T> parent) {
        if (compare(item, parent) < 0) {
            return parent.left = compare(item, parent.left) < 0
                    ? rotateWithLeftChild(parent.left)
                    : rotateWithRightChild(parent.left);
        } else {
            return parent.right = compare(item, parent.right) < 0
                    ? rotateWithLeftChild(parent.right)
                    : rotateWithRightChild(parent.right);
        }
    }

    private RedBlackNode<T> rotateWithRightChild(RedBlackNode<T> left) {
        return null;
    }

    private RedBlackNode<T> rotateWithLeftChild(RedBlackNode<T> left) {
        return null;
    }

    private final int compare(T item, RedBlackNode<T> t) {
        if (t == header) return 1;
        else return item.compareTo(t.element);
    }

    private RedBlackNode<T> current, parent, grand, great;

    private void handleReorient(T item) {
        current.color = RedBlackNode.RED;
        current.left.color = RedBlackNode.BLACK;
        current.right.color = RedBlackNode.BLACK;

        if (parent.color == RedBlackNode.RED) {
            grand.color = RedBlackNode.RED;
            if ((compare(item, grand) < 0) != (compare(item, parent) < 0)) {
                parent = rotate(item, grand);
            }

            current = rotate(item, great);
            current.color = RedBlackNode.BLACK;
        }
        header.right.color = RedBlackNode.BLACK;
    }

    public void insert(T item) {
        current = parent = grand = header;
        nullNode.element = item;
        while (compare(item, current) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = compare(item, current) < 0 ? current.left : current.right;

            if (current.left.color == RedBlackNode.RED && current.right.color == RedBlackNode.RED) {
                handleReorient(item);
            }

            if (compare(item, parent) < 0) {
                parent.left = current;
            } else {
                parent.right = current;
            }

            handleReorient(item);
        }
    }
}
