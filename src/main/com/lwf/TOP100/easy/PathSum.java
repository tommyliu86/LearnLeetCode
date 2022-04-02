package com.lwf.TOP100.easy;

import java.util.*;

/**
 * author Administrator
 * time 2019-09-16-22:51
 * {@link 437.md}
 */
public class PathSum {
    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        reverse(root, new Stack<>(), sum);
        return count;
    }

    void reverse(TreeNode node, Stack<Integer> list, int sum) {
        if (node == null) return;
        int cursum = (list.isEmpty() ? 0 : list.peek()) + node.val;
        if (cursum == sum) count++;

        for (Integer integer : list) {
            if ((cursum - integer) == sum) count++;
        }
        list.add(cursum);
        reverse(node.left, list, sum);
        reverse(node.right, list, sum);
        list.pop();//移除当前的递归中添加进去的sum，保证在其他递归中不受影响！
    }


    class PathSum1 {
        int count = 0;

        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            reverse(root, new HashMap<>(), sum,0);
            return count;
        }

        void reverse(TreeNode node, Map<Integer, Integer> map, int sum, int pathSum) {
            if (node == null) return;
            pathSum = pathSum + node.val;
            if (pathSum == sum) count++;

            count += map.getOrDefault(pathSum - sum, 0);
            map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
            reverse(node.left, map, sum, pathSum);
            reverse(node.right, map, sum, pathSum);
            map.put(pathSum, map.getOrDefault(pathSum, 0) - 1);//移除当前的递归中添加进去的sum，保证在其他递归中不受影响！
        }
    }
}