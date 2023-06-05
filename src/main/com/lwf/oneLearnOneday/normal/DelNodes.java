package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/5/30 9:02
 */
public class DelNodes {
    /**
     *
     * 解题思路：dfs 深度优先遍历
     * 首先将要删除的节点存入一个 List 中，然后进行 dfs 遍历二叉树。
     * 如果当前节点需要删除，则将其左右子节点加入答案列表，并返回 null。
     * 如果当前节点不需要删除，则返回该节点。
     * 最后判断根节点是否需要删除，若不需要则加入答案列表。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    class Solution {
        List<TreeNode> ans=new ArrayList<>();   //存储最终结果的列表
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<Integer> delete=new ArrayList<>(); //存储需要删除的节点值
            for (int i : to_delete) {
                delete.add(i);                       //将需要删除的节点值添加到delete列表中
            }
            TreeNode dfs = dfs(root, delete);       //开始递归删除节点
            if (dfs!=null){
                ans.add(root);                      //如果root节点没有被删除,添加到ans列表中
            }
            return ans;                            //返回最终结果ans
        }

        //递归删除节点的函数
        public TreeNode dfs(TreeNode node,List<Integer> delete){
            if (node==null) return null;          //递归终止条件:如果node为空,返回null
            node.left=  dfs(node.left,delete);   //递归左子树
            node.right=  dfs(node.right,delete); //递归右子树

            if (delete.contains(node.val)){       //如果当前节点值在delete列表中
                if (node.left!=null) ans.add(node.left);  //添加左子节点到ans列表
                if (node.right!=null) ans.add(node.right);//添加右子节点到ans列表
                return null;                             //当前节点设置为null,已被删除
            }else{
                return node;                           //如果当前节点不在delete列表中,返回节点本身
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
