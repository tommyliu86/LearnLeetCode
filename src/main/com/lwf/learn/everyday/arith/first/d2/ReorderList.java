package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 16:25
 */
public class ReorderList {
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
        public void reorderList(ListNode head) {
            if (head==null||head.next==null){
                return ;
            }
            ListNode slow=head;
            ListNode fast=head.next;
            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }

            ListNode sec=slow.next;
            slow.next=null;

            ListNode pre=null;
            while (sec!=null){
                ListNode temp=sec.next;
                sec.next=pre;
                pre=sec;
                sec=temp;
            }
            sec=pre;
            ListNode cursor=head;
            while (cursor!=null&&sec!=null){
                ListNode f=cursor.next;
                ListNode s=sec.next;


                cursor.next=sec;
                sec.next=f;
                cursor=f;
                sec=s;
            }
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
