package com.lwf.classic.two;



import java.util.HashSet;
import java.util.Set;

public class DetectCycle {
    public class Solution {
        /**
         * 快慢指针
         * a+b+c+b=2a+2b
         * c+b=a+b
         * a=c
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast==slow) {
                    fast=head;
                    while (fast!= slow){
                        fast=fast.next;
                        slow=slow.next;
                    }
                    return slow;
                }
            }

            return null;


        }
    }

    public class Solution1 {
        /**
         * hash存储
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();

            while (head != null && !set.contains(head)) {
                set.add(head);
                head = head.next;
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
