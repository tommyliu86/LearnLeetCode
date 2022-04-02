package com.lwf.oldtime;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-07-29
 * see {@link /md/234.md}
 *
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next   ==null) {
            return true;
        }
        Stack<Integer> stack=new Stack<>();
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            stack.push(slow.val);
            fast=fast.next.next;
            slow=slow.next;

        }
        if (fast!=null) {
            stack.push(slow.val);
        }
        do{
            slow=slow.next;
            if (slow.val!=stack.pop()){
                return false;
            }
        }while (slow.next!=null);
        return true;
    }
    public boolean isPalindrome1(ListNode head) {
        if (head==null||head.next   ==null) {
            return true;
        }

        ListNode slow=head;
        ListNode fast=head.next;
        ListNode pre=null;
        ListNode temp=null;
        while (fast!=null&&fast.next!=null){
            temp=slow;
            fast=fast.next.next;
            slow=slow.next;
            temp.next=pre;
            pre=temp;

        }

        if (fast!=null) {
            temp=slow;
            slow=slow.next;
            temp.next=pre;
            pre=temp;
            head.next=slow;
        }else{
            head.next=slow;
            slow=slow.next;
        }
        fast=pre;
        do{
            if (slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next  ;
        }while (slow!=null);
        return true;
    }
}
