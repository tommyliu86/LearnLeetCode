package com.lwf.offer.two;



public class ReverseList {
    /**
     * 递归思路
     */
    class Solution {

        public ListNode reverseList(ListNode head) {
            if (head==null) return head;
            if (head.next==null){
                return head;
            }
            ListNode listNode = reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return listNode;
        }
    }
    class Solution1 {
        //递推
        public ListNode reverseList(ListNode head) {
            ListNode pre=null;
            ListNode cur=head;
            while (cur!=null){
                ListNode next=cur.next;
                cur.next=pre;
                pre=cur;
                cur=next;
            }

            return pre;
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
