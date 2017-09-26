package com.oab.lintcode;

public class LinkedListTest {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNum(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        int carryBit = 0;
        while (node1 != null && node2 != null) {
            int newVal = node1.val + node2.val + carryBit;
            if (newVal >= 10) {
                newVal -= 10;
                carryBit = 1;
            } else {
                carryBit = 0;
            }

            result.next = new ListNode(newVal);
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {

        }

        return result;
    }
}
