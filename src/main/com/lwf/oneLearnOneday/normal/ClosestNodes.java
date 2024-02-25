package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * from home
 * author: liuwenfei
 * time: 2024年2月24日 17点13分
 */
public class ClosestNodes {
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
     * 二叉搜索数，是排序数，因此我们找到排序数组，然后进行二分查找
     */
    class Solution {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            //注意，linklist的查询会变成O（n）每次
            List<Integer> list=new ArrayList<>();

            mid(root,list);
            List<List<Integer>> ans=new ArrayList<>();
            for (int i = 0; i < queries.size(); i++) {
                Integer query = queries.get(i);
                int half = half(list, query);

                Integer max = list.get(half);
                if (max.compareTo(query)<0){
                    ans.add(List.of(max,-1));
                } else if (max.compareTo(query)==0) {
                    ans.add(List.of(max,max));
                } else{
                    ans.add(List.of( half==0?-1:list.get(half-1), max));
                }

            }
            return ans;
        }
        public int half(List<Integer> list,int q){
            if (q<=list.get(0)){
                return 0;
            }else if (q>=list.get(list.size()-1)){
                return list.size()-1;
            }
            int i=0,j=list.size()-1;
            while (i<j){
                int m=i+(j-i)/2;
                if (list.get(m)<q){
                    i=m+1;
                }  else{
                    j=m;
                }
            }
            return j;
        }
        public void mid(TreeNode node,List<Integer> list){
            if (node==null){
                return;
            }
            mid(node.left,list);

            list.add(node.val);
            mid(node.right,list);
        }
    }
}
