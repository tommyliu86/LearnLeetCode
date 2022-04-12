package com.lwf.level1.linklist;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-12 14:24
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
    class test {
        public ListNode reverseList(ListNode head) {
            if (head==null||head.next == null) {
                return head;
            }
            ListNode newRoot = reverseList(head);
            if (head != null && head.next != null) {
                head.next.next = head;
                head.next = null;
            }
            return newRoot;
        }
    }
    class Solution {

        public ListNode reverseList(ListNode head) {
            if (head==null){
                return head;
            }
            ListNode pre = head;
            ListNode next = head;
            while (next != null) {

                ListNode temp = next.next;
                next.next = pre;
                pre = next;
                next = temp;
            }
            head.next=null;
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
