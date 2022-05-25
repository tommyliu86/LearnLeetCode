package com.lwf.learn.everyday.arith.second.day3;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-15 17:40
 */
public class DeleteDuplicates {
    /**
     * 递归解法，简单清晰。
     */
    class recursive {

        public ListNode deleteDuplicates(ListNode head) {
            if (head==null){
                return null;
            }
            boolean hasEqual=false;
            while (head.next!=null && head.next.val==head.val){
                hasEqual=true;
                head.next=head.next.next;
            }
            if (hasEqual){
                return deleteDuplicates(head.next);
            }else{
                head.next=deleteDuplicates(head.next);
                return head;
            }
        }
    }
    class Solution {
        /**
         * 利用栈进行遍历。栈顶保存的是去重后的节点，后续节点和该节点进行链接即可
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            Stack<ListNode> stack =new Stack<>();
            ListNode root=new ListNode();
            root.next=head;
            ListNode cursor=head;

            while (cursor!=null){
                if (stack.isEmpty()){
                    stack.push(cursor);
                    root.next=cursor;
                    cursor=cursor.next;

                }else{

                    if (stack.peek().val==cursor.val){
                        while (cursor!=null&& stack.peek().val==cursor.val){
                            cursor=cursor.next;
                        }
                        stack.pop();

                    }else{
                        stack.peek().next=cursor;
                        stack.push(cursor);
                        cursor=cursor.next;
                    }
                }

            }
            if (!stack.isEmpty()){
                stack.peek().next=null;
                return root.next;
            }else{
                return null;
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
