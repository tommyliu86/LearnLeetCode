package com.lwf.TOP100.normal;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-20 Time: 09:21
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return recursive(head);
    }

    /**
     * 递归解法 归并排序思想，先找到中点对链表进行二分，分解完成后再进行合并merge，
     */
    ListNode recursive(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode slow = node;
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode f = recursive(node);
        ListNode s = recursive(mid);
        ListNode virtualhead = new ListNode(0);
        ListNode h = virtualhead;
        while (f != null && s != null) {
            if (f.val > s.val) {
                h.next = s;
                s = s.next;
            } else {
                h.next = f;
                f = f.next;
            }
            h = h.next;

        }
        if (f != null) {
            h.next = f;
        }
        if (s != null) {
            h.next = s;
        }
        return virtualhead.next;
    }
}
