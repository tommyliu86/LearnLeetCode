package com.lwf.level1.linklist;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-12 13:54
 */
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
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root=new ListNode();
            root.next=head;
            int next = 0;
            ListNode cur = root;
            while (next < n) {
                cur = cur.next;
                next++;
            }
            ListNode pre = root;
            while (cur.next != null) {
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = pre.next.next;
            return root.next;
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
