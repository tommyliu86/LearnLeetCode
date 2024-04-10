package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. 所有可能的真二叉树
 *
 * @author: liuwenfei
 * @date: 2024/4/2-8:57
 */
public class AllPossibleFBT {
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

    /**
     * 需要构建树，因此需要进行树的划分，使用递归构建每个子树，然后返回
     * 1. 递归解法，直接进行左和右子树的构建，然后组成树进行返回
     */
    class Solution {
        //1. 真子树，肯定是2*n+1，也就是奇数，那么我们每个根节点，左+右肯定是奇数划分方法，按照这个可以从左向右进行划分
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> ans=new ArrayList<>();
             if (n%2==0){
                 return ans;
             }
             if (n==1){
                 ans.add(new TreeNode(0));
                 return ans;
             }
             //左子树的可能的个数
            for (int i = 1; i < n-1; i+=2) {
                List<TreeNode> left=allPossibleFBT(i);
                List<TreeNode> right=allPossibleFBT(n-1-i);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(0);
                        root.left=l;
                        root.right=r;
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }
}
