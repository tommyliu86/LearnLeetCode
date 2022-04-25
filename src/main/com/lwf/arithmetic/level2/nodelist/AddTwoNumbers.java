package com.lwf.arithmetic.level2.nodelist;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-25 12:38
 */
public class AddTwoNumbers {
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
         * 递归构建
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            recursive(l1, l2, 0);
            return l1;
        }

        public ListNode recursive(ListNode l1, ListNode l2, int up) {
            if (l1 == null && l2 == null && up == 0) {
                return null;
            }
            int i = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + up;
            if (l1 == null && l2 == null) {
                return new ListNode(i);
            } else {
                if (l1 == null) {
                    l2.val = i % 10;
                    l2.next = recursive(l1, l2.next, i / 10);
                    return l2;
                } else {
                    l1.val = i % 10;
                    l1.next = recursive(l1.next, l2 == null ? null : l2.next, i / 10);
                    return l1;
                }
            }
        }

        /**
         * 直接构建新列表
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            ListNode root = new ListNode();
            int up = 0;
            ListNode pre = root;
            while (l1 != null || l2 != null || up != 0) {
                int i = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + up;
                pre.next = new ListNode(i % 10);
                pre = pre.next;
                up = i / 10;
                l1 = (l1 == null ? null : l1.next);
                l2 = (l2 == null ? null : l2.next);

            }
            return root.next;
        }

        /**
         * 循环迭代 直接修改l1列表，判断条件比较麻烦
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode();
            int up = 0;
            ListNode pre = root;
            while (l1 != null || l2 != null || up != 0) {
                int i = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + up;

                if (l1 == null && l2 == null) {
                    pre.next = new ListNode(i % 10);

                } else if (l1 == null) {
                    pre.next = l2;
                    l2.val = i % 10;
                    l2 = l2.next;
                    pre = pre.next;
                } else {
                    pre.next = l1;
                    l1.val = i % 10;
                    l1 = l1.next;
                    if (l2 != null) {
                        l2 = l2.next;
                    }
                    pre = pre.next;
                }
                up = i / 10;
            }
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
