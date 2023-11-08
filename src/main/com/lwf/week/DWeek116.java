package com.lwf.week;

import java.util.Arrays;
import java.util.List;

public class DWeek116 {

    class Solution {
        //dp 动态规划
        // 0-1 背包问题
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
            //初始化dp数据，dp[0]=0，目标是0的子数组长度是0，表示没有
            int[][] dp = new int[nums.size()+1][target + 1];

            //依次遍历数据，然后更新dp记录 所有可能的组合
            for (int i = 0; i < nums.size(); i++) {
                Integer integer = nums.get(i);
            }
            return 0;
        }

        public int lengthOfLongestSubsequence2(List<Integer> nums, int target) {
            int[] t = new int[target + 1];
            for (int i = 1; i <= target; i++) {
                t[i] = -99999999;
            }
            int n = nums.size();
            for (int i = 0; i < n; i++) {
                int[] tt = new int[target + 1];
                int t1 = nums.get(i);
                for (int j = 0; j < t1 && j <= target; j++) {
                    tt[j] = t[j];
                }
                for (int j = t1; j <= target; j++) {
                    tt[j] = Math.max(t[j], t[j - t1] + 1);
                }
                t = tt;
            }
            return t[target] >= 0 ? t[target] : -1;
        }


        public int lengthOfLongestSubsequence1(List<Integer> nums, int target) {
            nums.sort(Integer::compareTo);

            for (int i = 0; i < nums.size(); i++) {


                int sum = 0;
                while (i < nums.size()) {
                    sum += nums.get(i);
                    if (sum == target) {
                        return i + 1;
                    } else if (sum > target) {
                        int j = 0;
                        while (j < i && sum - nums.get(j) != target) {
                            j++;
                        }
                        if (j == i) {

                        } else {
                            return i;
                        }
                    }
                    i++;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        // 11001111
        public int minChanges(String s) {

            int ans = 0;
            for (int i = 0; i < s.length(); i += 2) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    ans++;
                }
            }
            return ans;
        }
    }

    class Solution4 {
        public int sumCounts(int[] nums) {
            int mod = 1000_000_000 + 7;
            int ans = nums.length;
            int[] marks = new int[100001];
            for (int i = 2; i <= nums.length; i++) {
                Arrays.fill(marks, 0);
                int pre = 0, post = 0;
                int count = 0;
                while (post < nums.length) {
                    while (post - pre < i) {
                        Integer integer = nums[post++];
                        marks[integer]++;
                        if (marks[integer] == 1) {
                            count++;
                        }
                    }
                    ans = (ans + count * count) % mod;
                    Integer integer = nums[pre++];
                    marks[integer]--;
                    if (marks[integer] == 0) {
                        count--;
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int sumCounts(List<Integer> nums) {
            int mod = 1000_000_000 + 7;
            int ans = nums.size();
            for (int i = 2; i <= nums.size(); i++) {
                int[] marks = new int[101];
                int pre = 0, post = 0;
                int count = 0;
                while (post < nums.size()) {
                    while (post - pre < i) {
                        Integer integer = nums.get(post++);
                        marks[integer]++;
                        if (marks[integer] == 1) {
                            count++;
                        }
                    }
                    ans = (ans + count * count) % mod;
                    Integer integer = nums.get(pre++);
                    marks[integer]--;
                    if (marks[integer] == 0) {
                        count--;
                    }
                }
            }
            return ans;
        }
    }
}
