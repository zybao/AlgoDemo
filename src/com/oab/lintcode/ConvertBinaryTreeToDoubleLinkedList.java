package com.oab.lintcode;

public class ConvertBinaryTreeToDoubleLinkedList {
    public class TreeNode{
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class DoubleLinkedList{
        int val;
        DoubleLinkedList prev, next;

        public DoubleLinkedList(int val) {
            this.val = val;
            this.prev = this.next = null;
        }
    }


}
