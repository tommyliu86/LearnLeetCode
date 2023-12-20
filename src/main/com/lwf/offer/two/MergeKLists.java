package com.lwf.offer.two;

/**
 * LCR 078. 合并 K 个升序链表
 * @author liuwenfei
 * @date 2023/12/20 9:28
 */
public class MergeKLists {
    /**
     * 合并链表，直接使用归并方法，进行切分后的合并即可
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length==0){
                return null;
            }
            return merge(lists,0,lists.length-1);
        }
        public ListNode merge(ListNode[] lists,int i,int j){
            if (i==j){
                return lists[j];
            }
            int m=i+(j-i)/2;
            ListNode l1=merge(lists,i,m);
            ListNode l2=merge(lists,m+1,j);
            ListNode newHead=new ListNode();
            ListNode cursor=newHead;
            while (l1!=null&&l2!=null){
                if (l1.val>l2.val) {
                    cursor.next=l2;
                    l2=l2.next;
                }else{
                    cursor.next=l1;
                    l1=l1.next;
                }
                cursor=cursor.next;
            }
            cursor.next=l1==null?l2:l1;
            return newHead.next;
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
