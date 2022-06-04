package com.lwf.learn.everyday.data.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-04 15:49
 */
public class DetectCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set=new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return head;
                }
                set.add(head);
                head=head.next;
            }
            return  null;
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
