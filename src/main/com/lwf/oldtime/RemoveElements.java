package com.lwf.oldtime;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        if (head.next==null){
            if (head.val==val) return null;
            else return head;
        }

        ListNode prehead=new ListNode(0) ;
        prehead.next=head;
        ListNode pre=prehead;
        ListNode cursor=head;
        while (cursor!=null){
            if (cursor.val==val){
                pre.next =cursor.next;
                cursor=cursor.next;
            }else {
                cursor = cursor.next;
                pre = pre.next;
            }
        }
        return prehead.next;
    }
}

