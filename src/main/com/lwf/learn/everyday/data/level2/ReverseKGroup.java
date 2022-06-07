package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-06 11:15
 */
public class ReverseKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return head;
            }
            ListNode cursor = head;
            int i = 0;
            while (i < k && cursor != null) {
                i++;
                cursor = cursor.next;
            }
            if (i < k) {
                return head;
            }
            ListNode last = head;

            ListNode pre = null;
            while (head != null && head != cursor) {
                ListNode temp = head.next;

                head.next = pre;
                pre = head;
                head = temp;
            }
            last.next = reverseKGroup(cursor, k);
            return pre;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
