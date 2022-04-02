package com.lwf.oldtime;

import java.util.HashSet;

/**
 * author Administrator
 * time 2019-07-18
 */
public class GetIntersectionNode {
}


 class ListNode {
  public  int val;
   public ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

 class Solution {
     public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
         if (headA==null ||headB==null ) return null ;
         HashSet<ListNode> set=new HashSet<>();
         while (headA!=null ){
             set.add(headA);
             headA= headA.next;
         }
         while (headB!=null){
             if (set.contains(headB)){
                 return headB;
             }else  {
                 headB= headB.next;
             }
         }
         return null;
     }

     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null ||headB==null ) return null ;
        ListNode CursorA=headA;
        ListNode CursorB=headB;
        ListNode endA=null;
        ListNode endB=null;
        while (CursorA!=CursorB){
            if (endA!=null&endB!=null&&endA!=endB){
                return null;
            }
            if (CursorA.next==null){
                endA=CursorA;
                CursorA=headB;

            }else{
                CursorA=CursorA.next;
            }
            if (CursorB.next ==null) {
                endB=CursorB;
                CursorB=headA;

            }else {
                CursorB=CursorB.next;
            }
        }
        return CursorA;
     }

 }