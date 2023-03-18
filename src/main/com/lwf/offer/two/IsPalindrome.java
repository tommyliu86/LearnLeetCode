package com.lwf.offer.two;

import com.lwf.learn.everyday.dp.level1.WiggleMaxLength;

/**
 * @author liuwenfei
 * @date 2023/3/3 19:46
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '9');
        System.out.println((int) 'a');
        System.out.println((int) 'b');
        System.out.println((int) 'B' + 'a' - 'A');
    }


    class Solution {
        /**
         * 快慢指针+反转链表
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            ListNode slow=head;
            ListNode fast=head.next;
            while (fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            ListNode pre=null;
            ListNode cur=slow.next;
            slow.next=null;
            while (cur!=null){
                ListNode temp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=temp;
            }
            while (pre!=null){
                if (pre.val==head.val){

                    pre=pre.next;
                    head=head.next;
                }else{
                    return false;
                }
            }
            return true;
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

    /**
     * 双指针
     */
    class Solution1 {
        public boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < j && !isChar(s.charAt(i))) {
                    i++;
                }
                while (i < j && !isChar(s.charAt(j))) {
                    j--;
                }
                if (!isEqual(s.charAt(i), s.charAt(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean isChar(char a) {
            if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z') || (a >= '0' && a <= '9')) {
                return true;
            }
            return false;
        }

        public boolean isEqual(char a, char b) {

            if ((a >= 'A' && a <= 'Z')) {
                a = (char) (a + 'a' - 'A');
            }
            if ((b >= 'A' && b <= 'Z')) {
                b = (char) (b + 'a' - 'A');
            }
            return a == b;
        }
    }
}
