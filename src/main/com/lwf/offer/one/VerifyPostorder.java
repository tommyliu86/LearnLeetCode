package com.lwf.offer.one;

import java.util.Deque;
import java.util.LinkedList;

public class VerifyPostorder {
    /**
     * 考虑 遍历特性，左右根 反过来是 根右左，因此向右边走是变大，当换到左数时，左数都小于根，
     */
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            Deque<Integer> queue = new LinkedList<>();
            int curRoot = Integer.MAX_VALUE;
            for (int i = postorder.length - 1; i >= 0; i--) {
                int cur = postorder[i];
                if (curRoot < cur) return false;
                while (!queue.isEmpty() && queue.peekLast() > cur) {
                    curRoot = queue.removeLast();
                }
                queue.add(cur);
            }
            return true;
        }

    }

    /**
     * 递归，左子树+右子树校验，递归中需要对左树+右树的大小进行遍历校验
     */
    class Solution1 {
        public boolean verifyPostorder(int[] postorder) {
            return reverse(postorder, 0, postorder.length - 1);
        }

        public boolean reverse(int[] ints, int l, int r) {
            if (l >= r) {
                return true;
            }
            int top = ints[r];
            int i = l;
            while (ints[i] < top) {
                i++;
            }
            int m = i;
            while (ints[i] > top) {
                i++;
            }
            return i == r && reverse(ints, l, m - 1) && reverse(ints, m, r - 1);
        }

    }
}
