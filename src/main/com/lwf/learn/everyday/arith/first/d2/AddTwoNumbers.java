package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 18:07
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root=new ListNode();
            ListNode cursor=root;
            int step=0;
            while (l1!=null||l2!=null||step!=0){
                int cur = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + step;
                step=cur/10;
                cur%=10;
                ListNode node = new ListNode(cur);

                cursor.next=node;

                cursor=cursor.next;
                l1=l1==null?l1:l1.next;
                l2=l2==null?l2:l2.next;
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
