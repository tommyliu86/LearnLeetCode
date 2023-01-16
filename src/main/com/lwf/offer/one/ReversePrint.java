package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/13 11:26
 */
public class ReversePrint {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    /**
     * 递归解题
     */
    class Solution {
        int length=0;
        public int[] reversePrint(ListNode head) {
            return reverse(head,1);
        }
        public int[] reverse(ListNode node,int l){
            if (node==null){
                int[] ans=new int[length];
                return ans;
            }
            length++;
            int[] ans= reverse(node.next,l+1);
            ans[length- l]=node.val;
            return ans;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
