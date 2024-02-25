package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 235. 二叉搜索树的最近公共祖先
 * Created with IntelliJ IDEA.
 * User: liuwenfei14
 * Date: 2019-11-29 Time: 09:06
 */
public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 通过找到每个节点的查找路径，当两个查找路径分叉的地方，就是两个的公共祖先。
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> parentp=new ArrayList<>();
            List<TreeNode> parentq=new ArrayList<>();
            find(root,p,parentp);
            find(root,q,parentq);

            TreeNode ans=root;
            int i=0;
            while (i<parentp.size()&&i<parentq.size()){
                if (parentp.get(i).val==parentq.get(i).val){
                    ans=parentp.get(i);
                    i++;
                }else{
                    break;
                }
            }
            return ans;
        }
        public void find(TreeNode node,TreeNode f,List<TreeNode> path){
            path.add(node);
            if (node.val==f.val){
                return;
            }else if (node.val>f.val){
                find(node.left,f,path);
            }else {
                find(node.right,f,path);
            }
        }
    }
}
