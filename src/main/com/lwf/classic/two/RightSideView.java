package com.lwf.classic.two;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/5/23 9:41
 */
public class RightSideView {
    /**
     * 深度遍历，使用数组存储结果，遍历时传递当前层数，每层只记录一个右侧
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans=new ArrayList<>();
            if (root==null)return ans;
            dfs(root,1,ans);
            return ans;
        }
        public void dfs(TreeNode node,int level,List<Integer> ans){
            if (level>ans.size()){
                ans.add(node.val);
            }
            if (node.right!=null)dfs(node.right,level+1,ans);
            if (node.left!=null)dfs(node.left,level+1,ans);
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
