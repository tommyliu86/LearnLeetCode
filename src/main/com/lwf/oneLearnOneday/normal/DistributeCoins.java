package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/7/14 8:56
 */
public class DistributeCoins {
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
        /**
         * 本题的难点在于思路，首先要清楚问的是什么，题目规定每次移动一个金币，每次一步，求最后的总步数。
         * 那我们从常规思路考虑如何操作，假设一个三节点的情况，我们会观察左节点，根节点和右节点分别是多少，然后考虑移动，
         * 那如果左右不是一个节点而是变成子树的话，还能这样吗？
         * 其实这个就是本题思路，把左右子树都当成整体考虑，这时我们会知道从每个树中会移动多少个金币，深度遍历下去，找到所有的值相加即可。
         *
         * 作者：tommy-23
         * 链接：https://leetcode.cn/problems/distribute-coins-in-binary-tree/solution/si-lu-wei-wang-shen-du-you-xian-bian-li-g23n3/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         * @param root
         * @return
         */
        public int distributeCoins(TreeNode root) {
            // 调用深度优先搜索方法
            dfs(root);
            // 返回移动次数
            return count;
        }

        // 记录移动次数
        int count = 0;

        // 深度优先搜索方法，返回一个长度为2的整型数组
        public int[] dfs(TreeNode node) {
            // 创建整型数组 ans，长度为2，用于存储两个值
            int[] ans = new int[2];
            // 创建整型数组 l，r，分别用于存储左子树和右子树的结果
            int[] l = new int[2];
            int[] r = new int[2];
            // 判断左子树是否为空，若不为空，则递归调用 dfs 方法获取返回值赋给 l 数组
            if (node.left != null) {
                l = dfs(node.left);
            }
            // 判断右子树是否为空，若不为空，则递归调用 dfs 方法获取返回值赋给 r 数组
            if (node.right != null) {
                r = dfs(node.right);
            }
            // ans[0] 存储总的硬币数，ans[1] 存储总的节点数
            ans[0] = l[0] + r[0] + node.val;
            ans[1] = l[1] + r[1] + 1;
            // 更新移动次数，将当前节点的硬币数与节点数之差的绝对值累加到 count 中
            count += Math.abs(ans[0] - ans[1]);
            // 返回结果数组
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
