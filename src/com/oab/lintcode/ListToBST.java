package com.oab.lintcode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 Have you met this question in a real interview? Yes
 Example
 2
 1->2->3  =>   / \
 1   3
 */
public class ListToBST {
    private ListNode current;
    private int getListLength(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}
