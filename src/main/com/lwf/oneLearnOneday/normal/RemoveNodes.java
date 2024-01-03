package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2024/1/3 9:12
 */
public class RemoveNodes {

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

    /**
     * 链表递归即可
     */
    class Solution {
        public ListNode removeNodes(ListNode head) {
            if (head==null||head.next==null){
                return head;
            }
            ListNode next = removeNodes(head.next);
            if (head.val<next.val){
                return next;
            }else{
                head.next=next;
                return head;
            }
        }
    }
}
