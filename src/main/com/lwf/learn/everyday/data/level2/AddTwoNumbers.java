package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 14:25
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
            int step=0;
            ListNode cursor=root;
            while (l1!=null||l2!=null||step!=0){
                int sum=(l1==null?0:l1.val)+(l2==null?0:l2.val)+step;
                step=sum/10;
                ListNode listNode = new ListNode(sum % 10);
                cursor.next=listNode;

                l1=l1==null?null:l1.next;
                l2=l2==null?null:l2.next;
                cursor=cursor.next;
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
