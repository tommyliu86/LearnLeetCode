package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/12 9:44
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
            ListNode slow=head;
            ListNode fast=head;
            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode sec=null;
            ListNode cur=slow.next;
            slow.next=null;
            while (cur!=null){
                ListNode temp=cur.next;
                cur.next=sec;
                sec=cur;
                cur=temp;
            }
            ListNode l1=head.next,l2=sec,current=head;
            while (l1!=null&&l2!=null){
                current.next=l2;
                l2=l2.next;

                current.next.next=l1;
                l1=l1.next;
                current=current.next.next;
            }
           current.next=l1;

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
