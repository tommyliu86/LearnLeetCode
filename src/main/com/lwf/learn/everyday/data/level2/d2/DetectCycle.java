package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-29 15:15
 */
public class DetectCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null||head.next==null) {
                return null;
            }
            /**
             * 环状链表的解法和快慢指针找链表中点的方法不一样的，不应该用0，1来作为起始点，而应该都用0作为起始点。
             */
            ListNode slow = head.next;
            ListNode fast = head.next.next;
            while (fast != null && fast.next != null && fast != slow) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            ListNode cursor = head;
            while (cursor != slow) {
                cursor = cursor.next;
                slow = slow.next;
            }
            return cursor;
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
}
