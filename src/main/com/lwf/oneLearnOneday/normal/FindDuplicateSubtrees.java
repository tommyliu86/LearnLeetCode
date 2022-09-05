package com.lwf.oneLearnOneday.normal;

import java.util.*;

public class FindDuplicateSubtrees {
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
        Map<String,TreeNode> map=new HashMap<>();
        Map<String,TreeNode> rtn=new HashMap<>();
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);

            return new ArrayList<>( rtn.values());
        }
        public String dfs(TreeNode node){
            if (node==null){
                return null ;
            }

            StringBuilder key = new StringBuilder();
            key.append(node.val).append(",").append(dfs(node.left))
                    .append(",").append(dfs(node.right));
            if (!map.containsKey(key.toString())){

                map.put(key.toString(),node);
            }else{
                rtn.putIfAbsent(key.toString(),node);
            }
            return key.toString();
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
