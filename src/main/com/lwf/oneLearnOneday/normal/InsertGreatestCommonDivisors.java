package com.lwf.oneLearnOneday.normal;

/**
 * 2807. 在链表中插入最大公约数
 * @author liuwenfei
 * @date 2024/1/8 9:02
 */
public class InsertGreatestCommonDivisors {
    /**
     * 公约数计算方法，辗转除余
     */
    class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            if (head.next!=null){
                ListNode next = head.next;
                head.next=new ListNode(gcd(head.val,next.val));
                head.next.next=insertGreatestCommonDivisors(next);

            }
            return head;
        }
        public int gcd(int x,int y){
            if (y==0)return x;
            return gcd(y, x%y);
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
