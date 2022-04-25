package com.lwf.arithmetic.level2.nodelist;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-25 16:36
 */
public class OddEvenList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode root = listNode;
        for (int i = 1; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        new Solution().oddEvenList(root.next);
    }

    /**
     * 同时移动奇数和偶数，则最后结果奇数肯定！=null 偶数==null或 偶数。next==null。
     */
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode root = head;
            ListNode roott = head.next;
            ListNode even = head;
            ListNode odd = head.next;
            while (even != null && even.next != null && odd != null && odd.next != null) {
                even.next = even.next.next;
                odd.next = odd.next.next;

                even = even.next;
                odd = odd.next;
            }

            even.next = roott;
            return root;
        }
    }

    public static class ListNode {
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
