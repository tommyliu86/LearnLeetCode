package com.lwf.offer.two;

/**
 * LCR 067. 数组中两个数的最大异或值
 * https://leetcode.cn/problems/ms70jA/description/?envType=study-plan-v2&envId=coding-interviews-special
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(24));
        System.out.println(Integer.toBinaryString(28));
    }

    /**
     * 异或  是相同位上 两数不同=1，否则=0 使用二进制构建前缀数，
     */
    static class Solution {
        public int findMaximumXOR(int[] nums) {
            Node root = new Node();

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                root.add(num);
                int a = 0;
                Node cur = root;
                for (int j = 31; j >= 0; j--) {
                    int k = 1  & (num>>j);
                    if ((k == 0 && cur.n1 != null) || (k == 1 && cur.n0 != null)) {
                        //这里直接用1 左移j位，然后和a进行 或运算
                        a |= 1<<j;
                        cur = k == 0 ? cur.n1 : cur.n0;
                    } else {
                        cur = k == 0 ? cur.n0 : cur.n1;
                    }
                }
                ans = Math.max(ans, a);
            }
            return ans;
        }

        class Node {
            Node n0;
            Node n1;

            void add(int i) {
                Node cur = this;
                for (int j = 31; j >= 0; j--) {
                    int k = 1  & (i>>j);
                    if (k == 0 && cur.n0 == null) {
                        cur.n0 = new Node();
                    }
                    if (k == 1 && cur.n1 == null) {
                        cur.n1 = new Node();
                    }
                    cur = (k == 0 ? cur.n0 : cur.n1);
                }
            }
        }
    }
}
