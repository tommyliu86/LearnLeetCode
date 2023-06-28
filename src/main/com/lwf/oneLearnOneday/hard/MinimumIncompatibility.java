package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/6/28 9:18
 */
public class MinimumIncompatibility {

    /**
     * 二进制子集遍历算法： a=b； a=（a-1）&b；这样a就可以遍历到所有的b的子集情况！
     */
    class Solution {
        public int minimumIncompatibility(int[] nums, int k) {
            int n = nums.length, group = n / k, inf = Integer.MAX_VALUE;
            //所有的子集记录，值是当前元素记合可以分配的每个子集的不兼容之和，
            int[] dp = new int[1 << n];
            Arrays.fill(dp, inf);
            dp[0] = 0;

            //记录符合要求的子集的不兼容值
            HashMap<Integer, Integer> values = new HashMap<>();
            for (int mask = 1; mask < (1 << n); mask++) {
                //不是group个元素的子集不管
                if (Integer.bitCount(mask) != group) {
                    continue;
                }
                //记录当前组合中的最大值和最小值
                int mn = 20, mx = 0;
                //cur用于记录当前子集中出现过的值，用来判断当前子集是否有重复元素
                HashSet<Integer> cur = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    //获取自己在i位置的元素
                    if ((mask & (1 << i)) > 0) {

                        if (cur.contains(nums[i])) {
                            break;
                        }
                        cur.add(nums[i]);
                        mn = Math.min(mn, nums[i]);
                        mx = Math.max(mx, nums[i]);
                    }
                }
                if (cur.size() == group) {
                    values.put(mask, mx - mn);
                }
            }
            //直接遍历所有子集，只会是从0也就是一个元素都没使用的情况开始，mask=0的情况
            for (int mask = 0; mask < (1 << n); mask++) {
                if (dp[mask] == inf) {
                    continue;
                }
                //seen存如mask未使用的所有位置，这里的mask表示的是更大的子集
                HashMap<Integer, Integer> seen = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) == 0) {
                        seen.put(nums[i], i);
                    }
                }
                if (seen.size() < group) {
                    continue;
                }
                int sub = 0;
                for (int v : seen.values()) {
                    sub |= (1 << v);
                }
                int nxt = sub;
                while (nxt > 0) {
                    //nxt是符合要求的子集，如果
                    if (values.containsKey(nxt)) {
                        dp[mask | nxt] = Math.min(dp[mask | nxt], dp[mask] + values.get(nxt));
                    }
                    //使用这种算法，可以枚举到所有的sub的子集（不包含自身）
                    nxt = (nxt - 1) & sub;
                }
            }

            return (dp[(1 << n) - 1] < inf) ? dp[(1 << n) - 1] : -1;
        }
    }

    public static void main(String[] args) {
        int a=2*2*2*2*2-1;
        System.out.println(Integer.toBinaryString(a));
        int b=a;
        while (b>0){
            b=(b-1)&a;
            System.out.println(Integer.toBinaryString(b));
        }
    }


}
