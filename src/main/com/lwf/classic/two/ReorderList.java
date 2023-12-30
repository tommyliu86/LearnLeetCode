package com.lwf.classic.two;

public class ReorderList {
    /**
     * 1. 快慢指针找重点
     * 2.反转链表
     * 3.合并链表双指针
     */
    class Solution {
        public void reorderList(ListNode head) {
            ListNode slow=head;
            ListNode fast=head.next;
            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode pre=null;
            ListNode cur=slow.next;
            slow.next=null;
            while (cur!=null){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            ListNode p1=head;
            ListNode p2=pre;
            pre=new ListNode();
            while (p1!=null||p2!=null){
                pre.next=p1;
                ListNode temp=p1.next;
                p1.next=p2;
                p1=temp;
                pre=p2;
                p2=p2==null?null: p2.next;
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
