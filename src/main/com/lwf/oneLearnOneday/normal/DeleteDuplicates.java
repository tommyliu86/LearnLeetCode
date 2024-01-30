package com.lwf.oneLearnOneday.normal;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @author liuwenfei
 * @date 2024/1/15 9:22
 */
public class DeleteDuplicates {
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
     * 链表的递归遍历解法
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null||head.next==null)
                return head;
            boolean dup=false;
            ListNode next=head.next;
            while (next!=null&&next.val==head.val){
                dup=true;
                next=next.next;
            }
            if (dup){
                return deleteDuplicates(next);
            }else{
                head.next=deleteDuplicates(next);
                return head;
            }
        }
    }
}
