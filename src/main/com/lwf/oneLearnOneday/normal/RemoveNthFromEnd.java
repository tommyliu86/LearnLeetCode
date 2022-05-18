package com.lwf.oneLearnOneday.normal;



/**
 * author Administrator
 * time 2019-09-25-23:11
 * {@link 19.md}
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        com.lwf.TOP100.normal.ListNode head=new com.lwf.TOP100.normal.ListNode(1);
        head.next=new com.lwf.TOP100.normal.ListNode(2);
        new com.lwf.TOP100.normal.RemoveNthFromEnd().removeNthFromEnd(head,2);
    }
    public com.lwf.TOP100.normal.ListNode removeNthFromEnd(com.lwf.TOP100.normal.ListNode head, int n) {
        if (head.next==null&&n==1) return null;
        com.lwf.TOP100.normal.ListNode pre=new com.lwf.TOP100.normal.ListNode(0);
        pre.next=head;
        Reverse(pre,head,n);
        return pre.next;
    }
    int Reverse(com.lwf.TOP100.normal.ListNode pre, com.lwf.TOP100.normal.ListNode node, int n){
        int cur;
        if (node.next!=null ){
          cur= 1+  Reverse(node, node.next ,n);
        }
        else {
            cur= 1;
        }
        if (cur==n){
            if (null==pre){
                node=node.next;
            }else{

                pre.next=node.next;
            }
        }
        return cur;
    }
}

class ListNode {
     int val;
     com.lwf.TOP100.normal.ListNode next;
     ListNode(int x) { val = x; }
 }