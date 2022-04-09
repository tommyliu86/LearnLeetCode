package com.lwf.learn.everyday.first.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 10:01
 */
public class MergeTwoLists {
    class test {
        /**
         * 递归解法,利用递归来模拟拼接
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode cur;
            if (list1!=null&&list2!=null){

                if (list1.val<list2.val){
                    cur=list1;
                    cur.next=mergeTwoLists(list1.next,list2);
                }else{
                    cur=list2;
                    cur.next=mergeTwoLists(list1,list2.next);
                }
            }else{
                if (list1==null){
                    cur=list2;
                }else{
                    cur=list1;
                }
            }
            return cur;
        }
    }
    class Solution {
        /**
         * 双指针递推解法
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root=new ListNode();
            ListNode next=root;
            while (list1!=null&&list2!=null) {
                if (list1.val<list2.val){
                    next.next=list1;
                    list1=list1.next;
                }else{
                    next.next=list2;
                    list2=list2.next;
                }
                next=next.next;
            }
            if (list1==null){
                next.next=list2;
            }else{
                next.next=list1;
            }
            return root.next;
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
