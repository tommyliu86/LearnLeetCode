package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.List;

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
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            while (l1 != null) {
                list1.add(l1.val);
                l1=l1.next;
            }
            while (l2!=null){
                list2.add(l2.val);
                l2=l2.next;
            }
            int gap=0;
            int i1=list1.size()-1,i2=list2.size()-1;
            List<Integer> list3=new ArrayList<>();
            while (i1>=0||i2>=0||gap!=0){
                int cur=(i1>=0? list1.get(i1):0)+(i2>=0?list2.get(i2):0)+gap;
                list3.add(cur%10);
                gap=cur/10;
                i1--;
                i2--;
            }
            ListNode pre=new ListNode();
            ListNode cursor=pre;
            for (int i = list3.size() - 1; i >= 0; i--) {
                cursor.next=new ListNode(list3.get(i));
                cursor = cursor.next;
            }
            return pre.next;
        }
        public ListNode reverse(ListNode l1){
            ListNode pre1=null;
            while (l1!=null){
                ListNode p=l1.next;
                l1.next=pre1;
                pre1=l1;
                l1=p;
            }
            return pre1;
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
