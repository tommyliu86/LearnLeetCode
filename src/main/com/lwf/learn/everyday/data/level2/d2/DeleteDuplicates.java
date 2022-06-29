package com.lwf.learn.everyday.data.level2.d2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-29 17:46
 */
public class DeleteDuplicates {
    class Solution1 {
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null){
                return null;
            }
            if (head.next!=null&&head.val==head.next.val){
                ListNode cursor=head.next;
                while (cursor!=null&&cursor.val==head.val){
                    cursor=cursor.next;
                }
                return deleteDuplicates(cursor);
            }else{
                head.next=deleteDuplicates(head.next);
                return head;
            }
        }
    }

    /**
     * 使用栈，进行遍历迭代
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                if (stack.isEmpty()) {
                    stack.push(head);

                } else {
                    if (head.val == stack.peek().val) {
                        while (head.next != null && head.val == head.next.val) {
                            head = head.next;
                        }
                        stack.pop();
                    } else {
                        stack.peek().next = head;
                        stack.push(head);
                    }
                }
                head = head.next;
                if (!stack.isEmpty()) {
                    stack.peek().next = null;
                }
            }
            ListNode rtn = null;
            while (!stack.isEmpty()) {

                rtn = stack.pop();
            }
            return rtn;
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
