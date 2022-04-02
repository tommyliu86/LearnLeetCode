package com.lwf.TOP100.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * author Administrator
 * time 2019-09-12-23:29
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cursorA = headA;
        ListNode cursorB = headB;
        ListNode endA = null;
        ListNode endB = null;
        while (cursorA != cursorB) {
            if (endA != null && endB != null) {
                if (endA != endB) {
                    return null;
                }
            }
            if (cursorA.next != null) {
                cursorA = cursorA.next;
            } else {
                endA = cursorA;
                cursorA = headB;
            }
            if (cursorB.next != null) {
                cursorB = cursorB.next;
            } else {
                endB = cursorB;
                cursorB = headA;
            }

        }
        return cursorA;


    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            set.add(node.hashCode());
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node.hashCode())) return node;
            else {
                node = node.next;

            }
        }
        return null;
    }
}
