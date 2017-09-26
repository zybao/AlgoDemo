package com.oab.clrs;

public class HuffmanNode implements Comparable, Cloneable{
    public HuffmanNode left, right, parent;
    public int key;

    public HuffmanNode(HuffmanNode left, HuffmanNode right, HuffmanNode parent, int key) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.key = key;
    }

    @Override
    public int compareTo(Object o) {
        return this.key - ((HuffmanNode)o).key;
    }
}
