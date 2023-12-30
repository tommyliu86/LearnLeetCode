package com.lwf.classic.two;

public class RemoveNthFromEnd {
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
    /**
     * 双指针+滑动窗口
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode();
            pre.next=head;
            int i=0;
            ListNode right=pre;
            ListNode left=pre;
            while (i<n){
                right=right.next;
                i++;
            }
            while (right.next!=null){
                left=left.next;
                right=right.next;
            }
            left.next=left.next.next;
            return pre.next;

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
