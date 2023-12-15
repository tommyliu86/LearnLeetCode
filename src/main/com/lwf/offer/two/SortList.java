package com.lwf.offer.two;

/**
 * LCR 077. 排序链表
 *
 * @author liuwenfei
 * @date 2023/12/13 19:24
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 链表 递归+归并排序。归并排序是通过分治算法进行分为几个的单独的部分进行排序，然后进行合并，
     * 1.归并的核心是先分，分成两个部分
     * 2.然后合并，两部分排好序的数组，进行选择排序
     */
    class Solution {

        public ListNode sortList(ListNode head) {
        }
    }

    /**
     * 链表递归排序，直接遍历会导致超时
     */
    class Solution1 {

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            head.next = sortList(head.next);
            ListNode cursor = head;
            boolean changed = false;
            while (cursor.next != null && head.val > cursor.next.val) {
                changed = true;
                cursor = cursor.next;
            }
            if (changed) {
                ListNode newHead = head.next;
                head.next = cursor.next;
                cursor.next = head;
                return newHead;
            } else {
                return head;
            }
        }
    }
}
