package com.lwf.classic.two.tow;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    public class Solution {
        public ListNode detectCycle(ListNode head) {
           ListNode slow=head;
           ListNode fast=head;
           while (fast!=null&&fast.next!=null){

               slow=slow.next;
               fast=fast.next.next;
               if (slow==fast){
                   break;
               }
           }
           if (fast==null||fast.next==null){
               return null;
           }
           fast=head;
           while (fast!=slow){
               fast=fast.next;
               slow=slow.next;
           }
           return slow;
        }
    }
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head!=null&&!set.contains(head)){
                set.add(head);
                head=head.next;
            }
            return head;
        }
    }
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
