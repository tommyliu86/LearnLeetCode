package com.lwf.oneLearnOneday.easy;

/**
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
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

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null){
                return head;
            }

            head.next=deleteDuplicates(head.next);

            if (head.next!=null&& head.val==head.next.val){
                head.next=head.next.next;
            }
            return head;

        }
    }
}
