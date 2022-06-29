package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-29 16:54
 */
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
            ListNode ca=headA;
            ListNode cb=headB;
            boolean second=false;
            while (ca!=null){
                if (ca==cb){
                    return ca;
                }else{
                    ca=ca.next;
                    cb=cb.next;
                }
                if (ca==null&& !second){
                    second=true;
                    ca=headB;
                }
                if (cb==null){
                    cb=headA;
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
