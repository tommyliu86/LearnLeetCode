package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 13:51
 */
public class ReverseList {
    class Solution1 {
        /**
         * 递归
         * 1.入参为null表示链表为空，直接返回，入参的next==null表示到达链表尾部，直接返回尾节点，
         * 2.出参是链表的尾巴，链表反转后的新head。
         * 3.方法流程，先把next进行反转，返回的表示已经反转好的后续链表，出参是新的头，此时，当前节点的next仍然指向了自己的next，新链表的尾部，
         * 因此只要每次把当前节点再进行反转，把新head返回即可！！
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head==null|| head.next==null){
                return head;
            }

            ListNode pre=null;
            ListNode cur=head;

            while (cur!=null){
                ListNode temp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            return pre;
        }
    }
    class Solution {
        /**
         * 递归
         * 1.入参为null表示链表为空，直接返回，入参的next==null表示到达链表尾部，直接返回尾节点，
         * 2.出参是链表的尾巴，链表反转后的新head。
         * 3.方法流程，先把next进行反转，返回的表示已经反转好的后续链表，出参是新的头，此时，当前节点的next仍然指向了自己的next，新链表的尾部，
         * 因此只要每次把当前节点再进行反转，把新head返回即可！！
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head==null|| head.next==null){
                return head;
            }

            ListNode newHead = reverseList(head.next);
            head.next.next=head;
            head.next=null;
            return newHead;
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
