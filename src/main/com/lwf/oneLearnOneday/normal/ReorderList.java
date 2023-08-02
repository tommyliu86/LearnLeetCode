package com.lwf.oneLearnOneday.normal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liuwenfei
 * @date 2023/7/31 9:04
 */
public class ReorderList {
    /**
     * 双端队列
     */
    class Solution {
        public void reorderList(ListNode head) {
            Deque<ListNode> deque=new LinkedList<>();
            ListNode cursor=head;
            while (cursor!=null){
                deque.offer(cursor);
                cursor=cursor.next;
            }
            ListNode pre=new ListNode();
            while (!deque.isEmpty()){
                pre.next=deque.pollFirst();
                pre=pre.next;
                if (!deque.isEmpty()){
                    pre.next=deque.pollLast();
                    pre=pre.next;
                }
            }
            pre.next=null;
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
