package com.lwf.learn.everyday.coding.level2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 10:50
 */
public class ReorderList {
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
        public void reorderList(ListNode head) {
            Deque<ListNode> stack=new LinkedList<>();
            ListNode cursor=head;
            while (cursor!=null){
                stack.push(cursor);
                cursor=cursor.next;
            }
            ListNode root=new ListNode();
            boolean last=true;
            while (!stack.isEmpty()){
                if (last){
                    root.next= stack.removeLast();
                }else{
                    root.next=stack.remove();
                }
                root=root.next;
                root.next=null;
                last=!last;
            }
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
