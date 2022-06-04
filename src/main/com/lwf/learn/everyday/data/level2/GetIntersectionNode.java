package com.lwf.learn.everyday.data.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 16:18
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
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            ListNode ca=headA;
            ListNode cb=headB;
            boolean ac=false;
            boolean bc=false;
            while (ca!=null&&cb!=null){
                if (ca==cb){
                    return ca;
                }
                ca=ca.next;
                cb=cb.next;

                if (ca==null&&!ac){
                    ca=headB;
                    ac=true;
                }
                if (cb==null&&!bc){
                    bc=true;
                    cb=headA;
                }
            }
            return null;
        }
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> seta=new HashSet<>();

            while (headA!=null){
                seta.add(headA);
                headA=headA.next;
            }
            while (headB!=null){
                if (seta.contains(headB)){
                    return headB;
                }else{
                    headB=headB.next;
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
