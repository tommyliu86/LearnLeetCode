package com.lwf.classic.two.tow;

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
        //拼接a和b，这样会让a到b和b到a的长度相同，这样的话就可以同时到达相交点
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            boolean a=true,b=true;
            ListNode ca=headA,cb=headB;
            while (ca!=null&&cb!=null){
                if (ca==cb){
                    return ca;
                }
                ca=ca.next;
                cb=cb.next;
                if (ca==null&&a) {
                    ca=headB;
                    a=false;
                }
                if (cb==null&&b){
                    cb=headA;
                    b=false;
                }
            }
            return null;

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
