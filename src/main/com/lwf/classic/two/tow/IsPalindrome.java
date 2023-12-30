package com.lwf.classic.two.tow;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/4/7 11:17
 */
public class IsPalindrome {
    class Solution1 {
        public boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < j && !check(s.charAt(i))) {
                    i++;
                }
                while (i < j && !check(s.charAt(j))) {
                    j--;
                }
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean check(char c) {
            if (!Character.isLetter(c) && !(c >= '0' && c <= '9')) {
                return false;
            }
            return true;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {

            ListNode slow=head,fast=head;
            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            if (fast!=null){
                slow=slow.next;
            }
            ListNode pre=null;
            while (slow!=null){
                ListNode temp=slow.next;
                slow.next=pre;
                pre=slow;
                slow=temp;
            }
            while (pre!=null){
                if (pre.val!=head.val){
                    return false;
                }
                pre=pre.next;
                head=head.next;
            }
            return true;
        }
        public boolean isPalindrome1(ListNode head) {
            Stack<Integer> stack=new Stack<>();
            ListNode slow=head,fast=head;
            while (fast!=null&&fast.next!=null){
                stack.push(slow.val);
                slow=slow.next;
                fast=fast.next.next;
            }
            if (fast!=null){
                slow=slow.next;
            }
            while (slow!=null){
                if (stack.pop()!=slow.val){
                    return false;
                }
                slow=slow.next;
            }
            return true;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
