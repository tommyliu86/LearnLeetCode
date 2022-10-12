package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/10/12 9:18
 */
public class NumComponents {
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
        public int numComponents(ListNode head, int[] nums) {
            int max = Arrays.stream(nums).max().getAsInt();
            int[] indexs=new int[max+1];
            Arrays.fill(indexs,-1);
            for (int i = 0; i < nums.length; i++) {
                indexs[nums[i]]=i;
            }
            int count=0;
            ListNode cursor=head;
            while (cursor!=null){
                int subL=0;
                while (cursor!=null&&cursor.val<=max&&indexs[cursor.val]!=-1){
                    cursor=cursor.next;
                   subL++;
                }
                if (subL>0){
                    count++;
                }
                if (cursor!=null) {
                    cursor=cursor.next;
                }
            }
            return count;
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
