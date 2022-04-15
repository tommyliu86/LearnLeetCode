package com.lwf.level1.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-14 20:36
 */
public class IsSymmetric {
    class dp {
        public boolean isSymmetric(TreeNode root) {
            if (root==null){
                return true;
            }

            Queue<TreeNode> lefts=new LinkedList<>();
            lefts.add(root.left);
            Queue<TreeNode> rights=new LinkedList<>();
            rights.add(root.right);
            while (!lefts.isEmpty()&& !rights.isEmpty()){
                TreeNode left = lefts.poll();
                TreeNode right = rights.poll();
                if (left!=null&&right!=null){

                    if (left.val==right.val){
                        lefts.add(left.left);
                        lefts.add(left.right);
                        rights.add(right.right);
                        rights.add(right.left);
                    }else{
                        return false;
                    }
                }else if(left==null&&right==null){
                    continue;
                }else{
                    return false;
                }
            }
            return lefts.isEmpty()&& rights.isEmpty();
        }

    }
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root==null){
                return true;
            }
            return isSym(root.left, root.right);
        }
        private boolean isSym(TreeNode left,TreeNode right){
            if (left==null&&right==null){
                return true;
            }
            if ((left==null&&right!=null)||(left!=null&&right==null)){
                return false;
            }
            if (left.val==right.val){
                return isSym(left.left,right.right)&&isSym(left.right,right.left);
            }else{
                return false;
            }
        }
    }
}
