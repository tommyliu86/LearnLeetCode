package com.lwf.oneLearnOneday.easy;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-15-23:46
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode stack = null;

        while (fast != null && fast.next != null) {
            ListNode temp = slow;
            slow = slow.next;
            fast = fast.next.next;
            temp.next = stack;
            stack = temp;

        }
        if (fast != null) {

            slow = slow.next;

        }
        while (slow != null) {
            if (stack.val != slow.val) {
                return false;
            }
            slow = slow.next;
            stack = stack.next;
        }
        return true;
    }
}
