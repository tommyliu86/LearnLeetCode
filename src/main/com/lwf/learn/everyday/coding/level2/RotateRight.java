package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 12:35
 */
public class RotateRight {
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null||k==0) {
                return head;
            }
            int length = 1;
            ListNode last = head;
            while (last.next != null) {
                length++;
                last = last.next;
            }
            int step=length- k%length;
            if (step==length){
                return head;
            }
            ListNode pre=null;
            ListNode newhead=head;
            while (step>0){
                step--;
                pre=newhead;
                newhead=newhead.next;
            }
            pre.next=null;
            last.next=head;
            return newhead;


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
