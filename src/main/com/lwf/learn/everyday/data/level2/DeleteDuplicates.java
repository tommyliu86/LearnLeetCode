package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 16:31
 */
public class DeleteDuplicates {
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null){
                return head;
            }
            if (head.next!=null&& head.val==head.next.val){
                ListNode next=head.next;
                while (next!=null&& head.val==next.val){
                    next=next.next;
                }
                return deleteDuplicates(next);
            }else{
                head.next=deleteDuplicates(head.next);
                return head;
            }

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
