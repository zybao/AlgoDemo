package com.oab;

import org.omg.CORBA.PUBLIC_MEMBER;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    public T findMin() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMin(root).element;
    }

    public T findMax() throws Exception {
        if (isEmpty()) throw new Exception();
        return findMax(root).element;
    }

    private boolean contains(T t, BinaryNode<T> node) {
        if (t == null) return false;
        int compareTo = t.compareTo(node.element);
        if (compareTo < 0) {
            return contains(t, node.left);
        } else if (compareTo > 0) {
            return contains(t, node.right);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }

        return node;
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) return node;

        int compare = t.compareTo(node.element);
        if (compare < 0) {
            node.left = remove(t, node.left);
        } else if (compare > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }

        return node;
    }
}
