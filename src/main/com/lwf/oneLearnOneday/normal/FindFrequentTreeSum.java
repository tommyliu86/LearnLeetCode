package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 14:38
 */
public class FindFrequentTreeSum {
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
        public int[] findFrequentTreeSum(TreeNode root) {
            Map<Integer,Integer> map=new HashMap<>();
            dfs(root,map);
            int max=Integer.MIN_VALUE;
            List<Integer> rtn=new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                Integer value = entry.getValue();
                if (value==max){
                    rtn.add(entry.getKey());
                }else if (value>max){
                    max=value;
                    rtn.clear();
                    rtn.add(entry.getKey());
                }
            }
            int[] ans=new int[rtn.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=rtn.get(i);
            }
            return ans;
        }
        public int dfs(TreeNode node, Map<Integer,Integer> map){
            if (node==null){
                return 0;
            }
            int l=dfs(node.left,map);
            int r=dfs(node.right,map);
            int cur = node.val + l + r;
            map.put(cur,map.getOrDefault(cur,0)+1);
            return cur;
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
