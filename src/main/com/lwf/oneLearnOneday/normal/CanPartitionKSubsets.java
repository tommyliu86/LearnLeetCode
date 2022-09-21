package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2022/9/20 9:01
 */
public class CanPartitionKSubsets {
    /**
     * 状态测试+dp动态规划
     */
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int all = Arrays.stream(nums).sum();
            if (all % k != 0) {
                return false;
            }
            int per = all / k;
            Arrays.sort(nums);
            int n = nums.length;
            if (nums[n - 1] > per) {
                return false;
            }
            boolean[] dp = new boolean[1 << n];
            int[] curSum = new int[1 << n];
            dp[0] = true;
            for (int i = 0; i < 1 << n; i++) {
                if (!dp[i]) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (curSum[i] + nums[j] > per) {
                        break;
                    }
                    //当前没选中j
                    if (((i >> j) & 1) == 0) {
                        //选中j后的下一位数是next
                        int next = i | (1 << j);
                        //false表示没有处理过
                        if (!dp[next]) {
                            curSum[next] = (curSum[i] + nums[j]) % per;
                            dp[next] = true;
                        }
                    }
                }
            }
            return dp[(1 << n) - 1];
        }
    }

    /**
     * 状态压缩+记忆化搜索，状态压缩一般是使用位来模拟
     */
    class Solution2 {
        int[] nums;
        int per, n;
        boolean[] dp;


        public boolean canPartitionKSubsets(int[] nums, int k) {


            this.nums = nums;
            int all = Arrays.stream(nums).sum();
            if (all % k != 0) {
                return false;
            }
            per = all / k;
            Arrays.sort(nums);
            n = nums.length;
            if (nums[n - 1] > per) {
                return false;
            }
            //dp中存的是当前数组剩余的元素是哪些，初始化为所有剩余元素组合都是true。
            dp = new boolean[1 << n];
            Arrays.fill(dp, true);
            return dfs((1 << n) - 1, 0);
        }

        //s是当前剩余元素情况，p是当前使用元素的加的总和
        public boolean dfs(int s, int p) {
            if (s == 0) {
                return true;
            }
            if (!dp[s]) {
                return dp[s];
            }
            dp[s] = false;
            for (int i = 0; i < n; i++) {
                if (nums[i] + p > per) {
                    break;
                }
                if (((s >> i) & 1) != 0) {
                    if (dfs(s ^ (1 << i), (p + nums[i]) % per)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    class Solution1 {
        /**
         * 思路错了，这种方法仅适用于找固定元素和
         *
         * @param nums
         * @param k
         * @return
         */
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            Arrays.sort(nums);
            int remain = sum % k;
            sum /= k;
            if (remain != 0 || nums[nums.length - 1] > sum) {
                return false;
            }
            int j = nums.length - 1;
            for (int i = 0; j >= 0 && i < k; i++) {
                if (!map.containsKey(nums[j])) {
                    j--;
                }
                int re = sum - nums[j--];
                if (re == 0) {

                } else if (map.containsKey(re)) {
                    subFromMap(map, re);
                } else {
                    if (!findSum(nums, map, re)) {
                        return false;
                    }
                }
            }
            return true;

        }

        private void subFromMap(Map<Integer, Integer> map, int num) {
            int left = map.get(num) - 1;
            if (left != 0) {
                map.put(num, left);
            }
        }

        public boolean findSum(int[] nums, Map<Integer, Integer> map, int sum) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (left < right && !map.containsKey(nums[left])) {
                    left++;
                }
                if (left < right && !map.containsKey(nums[right])) {
                    right--;
                }
                if (left >= right) {
                    return false;
                }
                int newsum = nums[left] + nums[right];
                if (newsum > sum) {
                    right--;
                } else if (newsum == sum) {
                    subFromMap(map, nums[left]);
                    subFromMap(map, nums[right]);
                    return true;
                } else {
                    left++;
                }
            }
            return false;
        }
    }
}
