package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-06 13:44
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
            ListNode second=slow.next;
            slow.next=null;
            ListNode pre=null;
            while (second!=null){
                ListNode temp=second.next;
                second.next=pre;
                pre=second;
                second=temp;
            }
            while (head!=null&&pre!=null){
                ListNode next=head.next;
                ListNode next1=pre.next;
                head.next=pre;
                pre.next=next;
                head=next;
                pre=next1;
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
