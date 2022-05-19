package com.lwf.oneLearnOneday.normal;


/**
 * author Administrator
 * time 2019-10-29-22:13
 * {@link md/normal/98.md}
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return midOrder(root);
    }

    int max = 0;
    boolean init = false;

    Integer min=null;
    /**
     * 利用递归的中序方法验证
     *
     * @param node
     * @return
     */
    boolean midOrder1(TreeNode node) {
        if (node==null) return true;
        boolean left= midOrder1(node.left);
        if (!left)return false;
        if (min==null) {
            min=node.val;
        }else{
            if (node.val<=min) {
                return false;
            }else{
                min=node.val;
            }
        }
        boolean right=midOrder1(node.right);
        if (!right)return false;
        return true;

    }
    /**
     * 利用递归的中序方法验证
     *
     * @param node
     * @return
     */
    boolean midOrder(TreeNode node) {
        boolean rtn = true;
        if (node.left != null) {
            if (node.left.val < node.val) {
                rtn = midOrder(node.left);
            } else {
                return false;
            }
        }
        if (!init) {
            max = node.val;
            init = true;
        } else if (!rtn || node.val <= max) {
            return false;
        } else {
            max = node.val;
        }
        if (node.right != null) {
            if (node.right.val > node.val) {

                rtn = midOrder(node.right);
            } else {
                return false;
            }
        }
        return rtn;

    }

    /**
     * 递归利用了上下边界对单个节点进行验证，避免了普通递归遍历中对左右节点同时验证的繁琐
     * @param node
     * @param low
     * @param big
     * @return
     */
    public boolean helper(TreeNode node, Integer low, Integer big) {
        if (node==null) return true;
        int val = node.val;
        if (low != null && val <= low) return false;
        if (big != null && val >= big) return false;

        if (!helper(node.left, low, val)) return false;
        if (!helper(node.right, val, big)) return false;
        return true;
    }
}
