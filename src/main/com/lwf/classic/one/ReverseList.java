package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/13 11:34
 */
public class ReverseList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        /**
         * 双指针
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode newHead=null;
            ListNode cursor=head;
            while (cursor!=null){
                ListNode temp=cursor.next;
                cursor.next=newHead;
                newHead=cursor;
                cursor=temp;
            }
            return newHead;
        }

    }
    class Solution1 {

        /**
         * 递归
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
           return reverse(head);
        }
        public ListNode reverse(ListNode node){
            if (node==null|| node.next==null){
                return node;
            }
            ListNode next = node.next;
            ListNode head=reverseList(node.next);
            node.next=null;
            next.next=node;
            return head;
        }

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
