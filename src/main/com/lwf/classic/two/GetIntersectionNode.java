package com.lwf.classic.two;

public class GetIntersectionNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode le = headA;
            ListNode ri=headB;
            int changed=0;
            while (le!=ri&&le!=null&&ri!=null){
                le=le.next;
                ri=ri.next;
                if (le==null&&changed<2) {
                    le=headB;
                    changed++;
                }
                if (ri==null&&changed<2){
                    ri=headA;
                    changed++;
                }
            }
            return le==null||ri==null?null:le;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
