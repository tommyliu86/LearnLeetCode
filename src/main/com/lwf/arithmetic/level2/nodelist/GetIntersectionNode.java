package com.lwf.arithmetic.level2.nodelist;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-25 18:47
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
            ListNode cA=headA;
            ListNode cB=headB;
            boolean a=false,b=false;
            while (cA!=null&&cB!=null){
                if (cA==cB){
                    return cA;
                }
                if (cA.next==null&&!a) {
                    cA=headB;
                    a=true;
                }else{
                    cA=cA.next;
                }
                if (cB.next==null&&!b){
                    cB=headA;
                    b=true;
                }else{
                    cB=cB.next;
                }
            }
            return null ;
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
