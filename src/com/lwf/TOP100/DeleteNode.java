package com.lwf.TOP100;

/**
 * author Administrator
 * time 2019-07-30
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
