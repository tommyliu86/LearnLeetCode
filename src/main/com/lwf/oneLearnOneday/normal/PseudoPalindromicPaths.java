package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

public class PseudoPalindromicPaths {
    /**
     * 前序遍历+位运算， 使用位来保存1到9
     */
    class Solution {
//        public int pseudoPalindromicPaths(TreeNode root) {
//            front(root,0);
//            return count;
//        }
//        int count=0;
//        public void front(TreeNode node,int bit){
//            if (node==null)return;
//            bit=bit^(1<<node.val);
//            //判断
//            if (node.left==null&&node.right==null){
//                if (check(list)){
//                    count++;
//                }
//            }else{
//                front(node.left,list);
//                front(node.right,list);
//
//            }
//            list[node.val]--;
//        }
        public boolean check(int[] list){
            int ans=0;
            for (int i = 0; i < list.length; i++) {
                ans+=list[i]%2;
            }
            return ans<2;
        }
    }
    /**
     * 前序遍历+数组存储
     */
    class Solution2 {
        public int pseudoPalindromicPaths(TreeNode root) {
            front(root,new int[10]);
            return count;
        }
        int count=0;
        public void front(TreeNode node,int[] list){
            if (node==null)return;
            list[node.val]++;
            //判断
            if (node.left==null&&node.right==null){
                if (check(list)){
                    count++;
                }
            }else{
                front(node.left,list);
                front(node.right,list);

            }
            list[node.val]--;
        }
        public boolean check(int[] list){
            int ans=0;
            for (int i = 0; i < list.length; i++) {
                ans+=list[i]%2;
            }
            return ans<2;
        }
    }
    /**
     * 前序遍历+回文序列判断
     * 额。。伪回文是把所有节点的值进行排列看是否可以组成回文。。
     * 我这样的写法是路径中是否存在回文。。
     */
    class Solution1 {
        public int pseudoPalindromicPaths(TreeNode root) {
            front(root,new ArrayList<Integer>(),false);
            return count;
        }
        int count=0;
        public void front(TreeNode node, List<Integer> list,boolean has){
            if (!has){
                int cur = node.val;
                if ((list.size()>=1&&cur==list.get(list.size()-1))||(list.size()>=2&&cur==list.get(list.size()-2))){
                    has=true;
                }
            }

            if (node.left==null&&node.right==null){
                count+=has?1:0;
            }else{
                list.add(node.val);
                if (node.left!=null){
                    front(node.left,list,has);
                }
                if (node.right!=null){
                    front(node.right,list,has);
                }
                list.remove(list.size()-1);
            }
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
