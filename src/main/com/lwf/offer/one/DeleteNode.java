package com.lwf.offer.one;

import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/1/29 11:28
 */
public class DeleteNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA==null||headB==null) return null;
            ListNode a=headA;
            ListNode b=headB;
            boolean canEqual=true;
            while (a!=null&&b!=null){
                if (a.val==b.val&&canEqual) return a;
                a=a.next;
                b=b.next;
                if (a==null&&b!=null) {
                    a=headB;
                    canEqual=!canEqual;
                }
                if (a!=null&&b==null){
                    b=headA;
                    canEqual=!canEqual;
                }
            }
            return null;
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head=new ListNode(0);
            ListNode pre=head;
            while (l1!=null&&l2!=null){
               if (l1.val<l2.val){
                   pre.next=l1;
                   l1=l1.next;
               }else{
                   pre.next=l2;
                   l2=l2.next;
               }
               pre=pre.next;
            }
            pre.next=l1==null?l2:l1;
            return head.next;

        }
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode pre=head;
            for (int i = 0; i < k; i++) {
                head=head.next;
            }
            while (head!=null){
                head=head.next;
                pre=pre.next;
            }
            return pre;
        }
        public ListNode deleteNode(ListNode head, int val) {
            ListNode preHead=new ListNode(0);
            preHead.next=head;
            ListNode pre=preHead;
            ListNode cursor=head;
            while (cursor!=null){
                if (cursor.val==val) {
                    pre.next=cursor.next;
                    break;
                }else{
                    pre=cursor;
                    cursor=cursor.next;
                }
            }

            return preHead.next;
        }
    }
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
