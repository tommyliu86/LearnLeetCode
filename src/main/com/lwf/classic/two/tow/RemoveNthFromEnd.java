package com.lwf.classic.two.tow;

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
            ListNode pre = new ListNode();
            pre.next=head;
            ListNode re=pre;

            while (n>0){
                head=head.next;
            }
            while (head!=null){
                head=head.next;
                re=re.next;
            }
            re.next=re.next!=null? re.next.next.next:null;
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
