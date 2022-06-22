package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 17:53
 */
public class IsSubPath {
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
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (root==null) {
                return false;
            }
            if (isSub(head,root)) {
                return true;
            }else{
                return isSubPath(head,root.left)||isSubPath(head,root.right);
            }
        }
        //前面的链表都匹配才向下，否则false，这样在主方法中直接去 调用左右子树
        public boolean isSub(ListNode head,TreeNode node){
            if (head==null){
                return true;
            }
            if (node==null){
                return false;
            }
            if (head.val!=node.val){
                return false;
            }else{
                return isSub(head.next,node.left)||isSub(head.next,node.right);
            }
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
