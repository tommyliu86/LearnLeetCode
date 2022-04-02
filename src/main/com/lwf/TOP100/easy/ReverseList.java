package com.lwf.TOP100.easy;



/**
 * author Administrator
 * time 2019-09-15-22:32
 * {@link 206.md}
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode cursor=head.next;
        ListNode newHead=head;
        newHead.next =null;
        while (cursor!=null){
            ListNode temp=cursor.next;
            cursor.next=newHead;
            newHead=cursor;
            cursor=temp;
        }
        return newHead;
    }
    public ListNode reverseList2(ListNode head){
      if (head==null||head.next==null) return head;
      ListNode node=head;
      ListNode next=head.next   ;
      head.next=null;
      return reverse(node,next);
    }
    ListNode reverse(ListNode node,ListNode next){
        if (next.next!=null){
          ListNode rtn=  reverse(next,next.next);
          next.next=node;
          return rtn;
        }else{
            next.next=node;
            return next;
        }
    }
}
