package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-12-0:04
 * {@link 141.md}
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&slow!=null){
            if (slow==fast) return true;
            if (slow.next==null||fast.next==null||fast.next.next==null)
                return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }