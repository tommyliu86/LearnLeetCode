package com.lwf.offer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/1/30 14:50
 */
public class PathSum {
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
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> lists=new ArrayList<>();
            List<Integer> list=new ArrayList<>();
            if (root==null) return lists;
            dfs(root,list,0,target,lists);
            return lists;
        }
        private void dfs(TreeNode node,List<Integer> list,int sum, int target,List<List<Integer>> lists){

            list.add(node.val);
            sum+=node.val;
            if (node.left==null&&node.right==null){
                if (sum==target){
                    lists.add(new ArrayList<>(list));
                }
            }else{
                if (node.left!=null){
                    dfs(node.left,list,sum,target,lists);
                }
                if (node.right!=null){

                    dfs(node.right,list,sum,target,lists);
                }
            }
            sum-=node.val;
            list.remove(list.size()-1);
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
