package com.lwf.offer.two.tow;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/4/12 9:33
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
        //stack模拟
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1=new Stack<>();
            Stack<Integer> s2=new Stack<>();
            while (l1!=null){
                s1.push(l1.val);
                l1=l1.next;
            }
            while (l2!=null){
                s2.push(l2.val);
                l2=l2.next;
            }
            int gap=0;
            ListNode post=null;
            while (!s1.isEmpty()||!s2.isEmpty()||gap!=0){
                int i1 = (s1.isEmpty() ? 0 : s1.pop())+(s2.isEmpty()?0:s2.pop())+gap;
                ListNode listNode = new ListNode(i1 % 10);
                listNode.next=post;
                post=listNode;
                gap=i1/10;
            }
            return post;
        }

    }
    class Solution1 {
        //反转链表进行从后到前的计算
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);
            int gap=0;
            ListNode post=null;
            while (gap!=0||l1!=null||l2!=null){
                int i = gap + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
                ListNode listNode = new ListNode();
                listNode.next=post;
                listNode.val= i%10;
                post=listNode;
                gap=i/10;
                l1=l1==null?l1:l1.next;
                l2=l2==null?l2:l2.next;
            }
            return post;
        }
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
