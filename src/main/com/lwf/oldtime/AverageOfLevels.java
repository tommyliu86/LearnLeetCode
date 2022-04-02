package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-09-02-23:07
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<long[]> list = new ArrayList<>();
        preorder(root, 1, list);
        List<Double> listrtn = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            long[] ints = list.get(i);
            listrtn.add(i, Double.valueOf(ints[1]) / ints[0]);
        }
        return listrtn;
    }

    void preorder(TreeNode node, int level, List<long[]> list) {
        if (node == null) return;

        if (list.size() < level) {
            long[] ints = new long[2];
            ints[0] = 1;
            ints[1] = node.val;
            list.add(ints);
        } else {
            long[] ints = list.get(level - 1);
            ints[0] += 1;
            ints[1] += node.val;
        }
        preorder(node.left, level + 1, list);
        preorder(node.right, level + 1, list);
    }

}
