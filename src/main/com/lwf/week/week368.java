package com.lwf.week;

import java.util.*;

public class week368 {
    /**
     *  j<i 保证了 肯定可以用 k+1 和 k 组合出 s  ，
     *  那么 最少的k 和最多的k+1 的组合，是分割的最小组数，
     *  因此我们设有m个k+1 n个k， 则有 m*(k+1)+n*k=s
     *  分情况讨论 ：
     *  1.  m==0  则f（s）=n
     *  2.  n==0 则f（s）=m
     *  3. m！=0&&n！=0  f(s)= m+n  m 越大 则结果越小。
     *    m*(k+1)+n*k=s  => （m+n）*（k+1）=s+n
     *    这里的 n<=k 成立，反证： n>k的最小数是 k+1   则 m*(k+1)+(k+1)*n=s   变成了 全部都是（k+1）, 与前提矛盾
     *
     */
    class solution4 {
        // 把一个数分成 k或k+1个数一组，最少的分组数。 能否分组的决定的计算，使用k，如果能分成k和k+1，则向上取整计算
        public int minK(int s, int k) {
            //i 组
            int i = s / k;
            int j = s % k;
            if (j > i) {
                return -1;
            } else {
                //加上被除数-1 是向上取整的除法 余数 1.没余数，2.有余数 则 +1
                return (s + k) / (k + 1);
            }

        }
    }

    /**
     *
     */
    class Solution {
        public int minGroupsForValidAssignment(int[] nums) {
            Arrays.sort(nums);
            //map保存 元素 -》个数
            Map<Integer, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int i = 0, j = 0;
            while (j < nums.length) {
                while (j < nums.length && nums[i] == nums[j]) {
                    j++;
                }
                map.put(nums[i], j - i);
                min = Math.min(min, j - i);
                i = j;
            }
            int ans = Integer.MAX_VALUE;

            for (int k = min; k > 0; k--) {
                int c = 0;
                boolean ok = true;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    Integer v = entry.getValue();
                    if (v == k || v == k + 1) {
                        c++;
                    } else {
                        if (v % k > v / k) {
                            ok = false;
                            break;
                        } else {

                            int i1 = v / (k + 1);
                            int i2 = v % (k + 1);
                            c += i1 + (i2 == 0 ? 0 : 1);

                        }
                    }
                }
                if (ok) {
                    ans = Math.min(ans, c);
                }
            }
            return ans;

        }
    }

    class Solution2 {
        public int minimumSum(int[] nums) {
            int[] left = new int[nums.length];
            Arrays.fill(left, -1);
            int min = nums[0];
            for (int i = 1; i < left.length; i++) {
                min = Math.min(min, nums[i]);
                if (nums[i] > min) {
                    left[i] = min;
                }
            }
            int ans = Integer.MAX_VALUE;
            min = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                min = Math.min(min, nums[i]);
                if (left[i] != -1 && nums[i] > min) {
                    ans = Math.min(ans, left[i] + min + nums[i]);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }

    class Solution1 {
        public int minimumSum(int[] nums) {
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int b = nums[j];
                    if (b <= a) {
                        continue;
                    }
                    for (int k = j + 1; k < nums.length; k++) {
                        int c = nums[k];
                        if (c < b) {
                            ans = Math.min(ans, a + b + c);
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
