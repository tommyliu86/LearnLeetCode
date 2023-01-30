package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/30 9:21
 */
public class MergeInBetween {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            ListNode preHead=new ListNode(0,list1);
            ListNode cursor=list1;
            ListNode pre=preHead;
            int index=0;
            while (cursor!=null){
                if (index==a){
                    pre.next=list2;
                    while (list2!=null){
                        pre=list2;
                        list2=list2.next;
                    }

                    while (index!=b){
                        cursor=cursor.next;
                        index++;
                    }
                    pre.next=cursor.next;
                    break;
                }else{
                    pre=cursor;
                    cursor=cursor.next;
                    index++;
                }

            }
            return preHead.next;
        }
    }
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
