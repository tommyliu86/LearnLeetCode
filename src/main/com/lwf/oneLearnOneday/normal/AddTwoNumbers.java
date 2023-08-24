package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-03-22:57
 * {@link 2.md}
 */
public class AddTwoNumbers {
    class Solution {
        /**
         * 队列
         *

         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1=new Stack<>();
            Stack<Integer> s2=new Stack<>();
            while (l1 != null) {
                s1.add(l1.val);
                l1=l1.next;
            }
            while (l2!=null){
                s2.add(l2.val);
                l2=l2.next;
            }
            int  step=0;
            ListNode root=new ListNode(0);
            while (step!=0||!s1.isEmpty()|| !s2.isEmpty()){
                int i1 = !s1.isEmpty() ? s1.pop() : 0;
                int i2 = !s2.isEmpty() ? s2.pop() : 0;
                int i=step+i1+i2;
                step=i/10;
                i%=10;
                ListNode listNode = new ListNode(i);
                listNode.next=root.next;
                root.next=listNode;

            }
            return root.next;
        }
    }
        /**
         * 翻转链表

         */
    class Solution1 {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode n1 = reverse(l1);
            ListNode n2 = reverse(l2);
            int step=0;
            ListNode root=new ListNode(0);
            while (n1!=null||n2!=null||step!=0){
                int i1=n1==null?0:n1.val;
                int i2=n2==null?0:n2.val;
                int i = i1 + i2 + step;
                step=i/10;
                i%=10;
                ListNode listNode = new ListNode(i);
                listNode.next=root.next;
                root.next=listNode;
                n1=n1==null?null:n1.next;
                n2=n2==null?null:n2.next;
            }
            return root.next;
        }
        public ListNode reverse(ListNode listNode){
            ListNode pre=null;
            ListNode cur=listNode;
            while (cur!=null){
                ListNode temp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            return pre;
        }
    }
    class Solution2{

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int step=0;
            ListNode root=new ListNode(0);
            ListNode cursor=root;
            while (l1!=null||l2!=null||step!=0){
                int cur=(l1!=null? l1.val:0)+(l2!=null?l2.val:0)+step;
                step=cur/10;
                cur%=10;
                cursor.next=new ListNode(cur);
                l1=l1!=null? l1.next:null;
                l2=l2!=null? l2.next:null;
                cursor=cursor.next;

            }
            return root.next;
        }
        public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            int signal = 0;
            int sum = l1.val + l2.val;
            ListNode node = new ListNode(sum % 10);
            signal = sum / 10;
            ListNode v1 = l1.next;
            ListNode v2 = l2.next;
            ListNode v3 = node;
            while (v1 != null || v2 != null || signal != 0) {
                sum = (v1 == null ? 0 : v1.val) + signal + (v2 == null ? 0 : v2.val);
                v3.next = new ListNode(sum % 10);
                signal = sum / 10;
                v1 = (v1 == null ? null : v1.next);
                v2 = (v2 == null ? null : v2.next);
                v3 = v3.next;
            }
            return node;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
