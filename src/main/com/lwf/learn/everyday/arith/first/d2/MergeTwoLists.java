package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 10:42
 */
public class MergeTwoLists {
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
         * 递归算法。
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1==null||list2==null){
                return list1==null?list2:list1;
            }
            if (list1.val<=list2.val) {
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }else{
                list2.next=mergeTwoLists(list2.next,list1);
                return list2;
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
