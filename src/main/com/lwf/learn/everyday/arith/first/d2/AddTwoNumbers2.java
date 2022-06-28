package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 10:07
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
            l1=reverse(l1);
            l2=reverse(l2);

            ListNode root=new ListNode();
            int step=0;
            ListNode cursor=root;

            while (l1!=null||l2!=null||step!=0){
                int sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+step;
                step=sum/10;
                sum%=10;

                ListNode node = new ListNode(sum);
                cursor.next=node;

                cursor=cursor.next;
                l1=l1==null?l1:l1.next;
                l2=l2==null?l2:l2.next;
            }
            root=root.next;
            return reverse(root);

        }

        /**
         * 链表反转
         * @param node
         * @return
         */
        public ListNode reverse(ListNode node){
            ListNode pre=null;
            while (node!=null){
                ListNode temp=node.next;
                node.next=pre;
                pre=node;
                node=temp;

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
