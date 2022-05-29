package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 09:21
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
            int more=0;
            ListNode root=new ListNode();
            ListNode cursor=root;
            while (l1!=null||l2!=null||more!=0){
                int i = (l1!=null?l1.val:0) +more+(l2!=null?l2.val:0);
                more=i/10;
                ListNode listNode = new ListNode(i % 10);
                cursor.next=listNode;
                cursor=cursor.next;

                l1=(l1==null?null:l1.next);
                l2=(l2==null?null:l2.next);
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
