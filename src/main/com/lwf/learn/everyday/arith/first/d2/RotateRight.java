package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 14:02
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
            ListNode cursor=head;
            int l=0;
            while (cursor!=null){
                l++;
                cursor=cursor.next;
            }
            int step=l- (k+l)%l;
            if (step==l){
                return head;
            }

            ListNode right=head;
            while (step>0){
                right=right.next;
                step--;
            }

            ListNode newHead=right.next;
            right.next=null;

            cursor=newHead;
            while (cursor.next!=null){
                cursor=cursor.next;
            }
            cursor.next=head;
            return newHead;

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
