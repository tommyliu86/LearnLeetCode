package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/12 9:24
 */
public class ReverseList {
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
        public ListNode reverseList(ListNode head) {
            if (head == null) return head;
            if (head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next=null;
            return newHead;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode tem = head.next;
                head.next = pre;
                pre = head;
                head = tem;
            }
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
