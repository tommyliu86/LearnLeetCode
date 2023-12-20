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
            if (head == null || head.next == null) {
                return head;
            }
            //使用快慢指针，找到链表的中点
            ListNode slow = head, fast = head, pre = slow;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode second = sortList(pre.next);
            pre.next = null;
            head = sortList(head);
            return merge(head, second);

        }

        private ListNode merge(ListNode first, ListNode second) {
            ListNode newHead = new ListNode();
            ListNode cursor = newHead;
            while (first != null && second != null) {
                if (first.val > second.val) {
                    cursor.next = second;
                    second = second.next;
                } else {
                    cursor.next = first;
                    first = first.next;
                }
                cursor = cursor.next;
            }
            cursor.next = first != null ? first : second;
            return newHead.next;
        }
    }

    /**
     * 链表递归排序，直接遍历会导致超时，时间复杂度最差是 n*n
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
