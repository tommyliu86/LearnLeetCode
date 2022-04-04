package com.lwf.learn.everyday.first.day5;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-04 20:13
 */
public class RemoveNthFromEnd {
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
        /**
         * 双指针，快慢指针， 两个相差n步即可，找到快指针的next==null，这是slow.next就是要移除的。
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode root=new ListNode();
            root.next=head;
            ListNode slow=root;
            ListNode fast=root;
            while (fast.next!=null){
                if (n>0){
                    n--;
                    fast=fast.next;
                }else{
                    slow=slow.next;
                    fast=fast.next;
                }
            }
            slow.next=slow.next.next;
            return root.next;
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
