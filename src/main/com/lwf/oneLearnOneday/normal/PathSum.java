package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2022/10/27 9:04
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
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long,Integer> preSums=new HashMap<>();
            preSums.put(0L,1);
            return dfs(root,targetSum,preSums,0l);
        }
        public int dfs(TreeNode node, int target, Map<Long,Integer> preSums, long sum){
            if (node==null){
                return 0;
            }
            int ans=0;
           sum+= node.val;
           ans+=preSums.getOrDefault(sum - target,0);
           preSums.put(sum,preSums.getOrDefault(sum,0)+1);
           ans+=dfs(node.left,target,preSums,sum);
           ans+=dfs(node.right,target,preSums,sum);
            int i = preSums.get(sum) - 1;
            if (i==0){
                preSums.remove(sum);
            }else{
                preSums.put(sum,i);
            }
            return ans;
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
