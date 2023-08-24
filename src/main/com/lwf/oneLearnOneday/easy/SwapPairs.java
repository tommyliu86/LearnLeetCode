package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/8/11 9:24
 */
public class SwapPairs {
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
         * 递归
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
              if (head==null||head.next==null) return head;
              ListNode n=head.next;
              ListNode nn=swapPairs(head.next.next);
              head.next.next=head;
              head.next=nn;
              return n;
        }
        /**
         * 递推
         * @param head
         * @return
         */
        public ListNode swapPairs1(ListNode head) {
            ListNode pre=new ListNode();
            pre.next=head;
            ListNode cursor=pre;
            while (cursor.next!=null&&cursor.next.next!=null){
              ListNode nn=cursor.next.next;
              ListNode n=cursor.next;
              n.next=nn.next;

              cursor.next=nn;
              cursor.next.next=n;

              cursor=cursor.next.next;
            }
            return pre.next;
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
