package com.lwf.learn.everyday.arith.first.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 10:13
 */
public class ReverseList {
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
    class test {
        /**
         * 递归法。递归本质上模拟的和递推法不是一个思路，递归使用的是反转链表的指向，递归结果则是找到的链表最后的节点尾巴。
         * 因此不能再递归过程中使用返回结果，而应该考虑在递归过程中进行每一步的next->变为 <-pre
         * 利用出栈时进行 curr.next.next=curr，这样就是反转链表的next做法，同时需要curr.next=null，这样是断开环
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {

            if (head!=null&& head.next!=null){
                ListNode newHead = reverseList(head.next);
               head.next.next=head;
                head.next=null;
                return newHead;
            }else{
                return head;
            }
        }

    }
    class Solution {
        /**
         * 递推法。
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            ListNode next=head;
            ListNode pre=null;
            while (next!=null){
                ListNode temp=next.next;
                next.next=pre;
                pre=next;
                next=temp;
            }
            return pre;
        }
    }
}
