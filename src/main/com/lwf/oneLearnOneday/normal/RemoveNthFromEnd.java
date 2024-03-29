package com.lwf.oneLearnOneday.normal;



/**
 * author Administrator
 * time 2019-09-25-23:11
 * {@link 19.md}
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        new RemoveNthFromEnd().removeNthFromEnd(head,2);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null&&n==1) return null;
        ListNode pre=new ListNode(0);
        pre.next=head;
        Reverse(pre,head,n);
        return pre.next;
    }
    int Reverse(ListNode pre, ListNode node, int n){
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
     ListNode next;
     ListNode(int x) { val = x; }
 }