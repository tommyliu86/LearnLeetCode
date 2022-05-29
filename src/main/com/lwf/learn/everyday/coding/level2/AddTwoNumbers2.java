package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 10:08
 */
public class AddTwoNumbers2 {
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
            l1 = reversive(l1);
            l2 = reversive(l2);
            ListNode root=new ListNode();
            ListNode cursor=root;
            int more=0;
            while (l1!=null||l2!=null|| more!=0){
                int i=(l1!=null?l1.val:0)+(l2!=null?l2.val:0)+more;
                ListNode listNode = new ListNode(i % 10);
                cursor.next= listNode;
                cursor=cursor.next;

                more=i/10;
                l1=l1.next;
                l2=l2.next;
            }
            return reversive(root.next);

        }
        public ListNode reversive(ListNode listNode){
            ListNode pre=null;
            ListNode cur=listNode;
            while (cur.next!=null){

                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }
            return cur;
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
