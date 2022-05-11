package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-11 10:32
 */


import java.util.Arrays;

/**
 *
 * 二叉搜索树的构建，利用前序和中序遍历法来进行！
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        recursive(root, builder);
        if (builder.length()>0){
            return builder.delete(builder.length()-1,builder.length()).toString();
        }else{
            return builder.toString();
        }
    }

    private void recursive(TreeNode node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        builder.append(node.val).append(',');
        if (node.left != null) {
            recursive(node.left, builder);
        }
        if (node.right != null) {
            recursive(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null||data.length()==0){
            return null;
        }
        int[] pre = trans(data);
        int[] cur = new int[pre.length];
        for (int i = 0; i < cur.length; i++) {
            cur[i]=pre[i];
        }
        Arrays.sort(cur);
        return build(pre, 0, cur, 0, cur.length-1);

    }

    private TreeNode build(int[] pre, int i, int[] mid, int l, int r) {
        int v = pre[i];
        TreeNode treeNode = new TreeNode(v);
        int index = half(mid, l, r, v);
        if (l < index) {
            treeNode.left = build(pre, i + 1, mid, l, index - 1);
        }
        if (r > index) {
            treeNode.right = build(pre, i + index - l + 1, mid, index + 1, r);
        }
        return treeNode;
    }

    private int half(int[] nums, int l, int r, int t) {
        if (l >= r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == t) {
            return mid;
        } else if (nums[mid] > t) {
            return half(nums, l, mid - 1, t);
        } else {
            return half(nums, mid + 1, r, t);
        }
    }

    private int[] trans(String data) {
        String[] split = data.split(",");
        int[] rtn = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            rtn[i] = Integer.valueOf(split[i]);
        }
        return rtn;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;