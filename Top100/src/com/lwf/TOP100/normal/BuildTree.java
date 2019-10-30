package com.lwf.TOP100.normal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * author Administrator
 * time 2019-10-30-23:14
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        System.out.println(Arrays.copyOfRange(ints, 0, 1));
    }

    /**
     * 利用递归分别构建左右子树，preorder每次可以确认当前节点的值，而当前节点每次会切分出左右子树。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (curIndex < preorder.length && inorder != null && inorder.length > 0) {
            TreeNode cur = new TreeNode(preorder[curIndex++]);
            int index = findIndex(inorder, cur.val);
            int[] left = index < 1 ? null : Arrays.copyOfRange(inorder, 0, index);
            int[] right = index > inorder.length - 2 ? null : Arrays.copyOfRange(inorder, index + 1, inorder.length);
            cur.left = buildTree(preorder, left);
            cur.right = buildTree(preorder, right);
            return cur;
        } else {
            return null;
        }
    }

    int curIndex = 0;

    Integer findIndex(int[] ints, int element) {

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == element) {
                return i;
            }
        }
        return -1;
    }

    TreeNode recursive(int[] preorder, int[] curinorder) {
        if (curIndex < preorder.length && curinorder != null && curinorder.length > 0) {
            TreeNode cur = new TreeNode(preorder[curIndex]);
            int index = findIndex(curinorder, preorder[curIndex]);
            int[] left = Arrays.copyOfRange(curinorder, 0, index - 1);
            int[] right = Arrays.copyOfRange(curinorder, index + 1, curinorder.length);
            cur.left = recursive(preorder, left);
            cur.right = recursive(preorder, right);
            return cur;
        } else {
            return null;
        }
    }
}
