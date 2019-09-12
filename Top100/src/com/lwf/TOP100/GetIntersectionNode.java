package com.lwf.TOP100;

/**
 * author Administrator
 * time 2019-09-12-23:29
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode cursorA=headA;
        ListNode cursorB=headB;
        ListNode endA=null;
        ListNode endB=null;
        while (cursorA!=endB&&cursorB!=endA){

            if (endA!=null&&endB!=null){
                if (endA!=endB){
                    return null;
                }else  {
                   if( cursorA.equals(cursorB)){
                       return cursorA;
                   }
                }
            }
            if (cursorA.next!=null){
                cursorA= cursorA.next;
            }else{
                endA=cursorA;
                cursorA=headB;
            }
            if (cursorB.next    !=null){
                cursorB=cursorB.next    ;
            }else{
                endB=cursorB;
                cursorB=headA;
            }

        }
        return cursorA;


    }
}
