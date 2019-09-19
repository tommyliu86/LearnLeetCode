package com.lwf.TOP100.normal;

/**
 * author Administrator
 * time 2019-09-03-22:57
 * {@link 2.md}
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int signal = 0;
        int sum = l1.val + l2.val;
        ListNode node = new ListNode(sum % 10);
        signal = sum / 10;
        ListNode v1 = l1.next;
        ListNode v2 = l2.next;
        ListNode v3 = node;
        while (v1 != null || v2 != null || signal != 0) {
            sum = (v1 == null ? 0 : v1.val) + signal + (v2 == null ? 0 : v2.val);
            v3.next = new ListNode(sum % 10);
            signal = sum / 10;
            v1 = (v1 == null ? null : v1.next);
            v2 = (v2 == null ? null : v2.next);
            v3 = v3.next;
        }
        return node;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
