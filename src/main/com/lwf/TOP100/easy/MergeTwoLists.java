package com.lwf.TOP100.easy;

/**
 * author Administrator
 * time 2019-09-09-22:45
 */
public class MergeTwoLists {


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode rtn;
            if (l1!=null&&l2!=null){

              rtn =new ListNode(Math.min(l1.val,l2.val));
               if (l1.val<l2.val){
                   l1=l1.next;
               }
               else {
                   l2=l2.next;
               }
                rtn.next=mergeTwoLists(l1,l2);
            }else{
                rtn=(l1==null?l2:l1);
            }
                return rtn;
        }
    }
}
