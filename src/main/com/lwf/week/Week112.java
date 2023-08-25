package com.lwf.week;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Week112 {

    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            int maxLen = 0;

            int[] count = new int[100001];
            int max=0;
            for (int right = 0; right < nums.size(); right++) {

                count[nums.get(right)]++;
                max=Math.max()
                for (int left = right; left >= 0; left--) {
                    count[nums[left]]++;

                    if (count[nums[left]] == 1) {
                        unique++;
                    }

                    maxCount = Math.max(maxCount, count[nums[left]]);

                    int remaining = right - left + 1 - maxCount;
                    if (remaining <= k && (remaining == unique || remaining == 1)) {
                        maxLen = Math.max(maxLen, right - left + 1);
                    }
                }
            }
        }
    }
    public class Solution {
        public int maxEqualFreq(int[] nums, int k) {
            int maxLen = 0;

            for (int right = 0; right < nums.length; right++) {
                int[] count = new int[100001];
                int unique = 0;
                int maxCount = 0;

                for (int left = right; left >= 0; left--) {
                    count[nums[left]]++;

                    if (count[nums[left]] == 1) {
                        unique++;
                    }

                    maxCount = Math.max(maxCount, count[nums[left]]);

                    int remaining = right - left + 1 - maxCount;
                    if (remaining <= k && (remaining == unique || remaining == 1)) {
                        maxLen = Math.max(maxLen, right - left + 1);
                    }
                }
            }

            return maxLen;
        }
    }


    public class Solution {
        public int maximizeTheProfit(int n, List<List<Integer>> offers) {
            offers.sort((a, b) -> {
                if (a.get(1) != b.get(1)) {
                    return a.get(1) - b.get(1);
                } else {
                    return a.get(0)-b.get(0);
                }
            });

            int currentEnd = -1;
            int res = 0;

            for (int i = 0; i < offers.size(); i++) {
                if (offers.get(i).get(0) > currentEnd) {
                    res += offers.get(i).get(2);
                    currentEnd = offers.get(i).get(1);
                }
            }

            return res;
        }
    }

    class Solution {
        public int maximizeTheProfit(int n, List<List<Integer>> offers) {
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            offers.sort((a, b) -> {
                if (a.get(0) != b.get(0)) {
                    return a.get(0) - b.get(0);
                } else {
                    return a.get(1)-b.get(1);
                }
            });
            int curEnd=-1;
            int ans=0;
            for (int i = 0; i < offers.size(); i++) {
                Integer start = offers.get(i).get(0);
                Integer end = offers.get(i).get(1);
                Integer gold = offers.get(i).get(2);
                if (start>=curEnd){
                    ans
                }else{
                    ans+=gold;
                    curEnd=end;
                }
                if (offers.get(i).get(0) == 0) {
                    dp[offers[i][1]] = Math.max(dp[offers[i][1]], offers[i][2]);
                } else if (dp[offers[i][0]] != -1) {
                    dp[offers[i][1]] = Math.max(dp[offers[i][1]], dp[offers[i][0]] + offers[i][2]);
                }
            }

            int maxCoins = 0;
            for (int i = 0; i < n; i++) {
                maxCoins = Math.max(maxCoins, dp[i]);
            }

            return maxCoins;
        }


        public int maxCoins(int n, int[][] offers) {
            int[] dp = new int[n];
            Arrays.fill(dp, -1);

            Arrays.sort(offers, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });

            for (int i = 0; i < offers.length; i++) {
                if (offers[i][0] == 0) {
                    dp[offers[i][1]] = Math.max(dp[offers[i][1]], offers[i][2]);
                } else if (dp[offers[i][0]] != -1) {
                    dp[offers[i][1]] = Math.max(dp[offers[i][1]], dp[offers[i][0]] + offers[i][2]);
                }
            }

            int maxCoins = 0;
            for (int i = 0; i < n; i++) {
                maxCoins = Math.max(maxCoins, dp[i]);
            }

            return maxCoins;
        }
    }


    class Solution2 {
        public int minimumSum(int n, int k) {
            Set<Integer> set = new HashSet<>();
            int ans = 0;
            int i = 0;
            int j = 1;
            while (i < n) {
                if (!set.contains(j)) {

                    ans += j;
                    set.add(k - j);
                    i++;
                }
                j++;
            }
            return ans;
        }
    }

    class Solution1 {
        public boolean isAcronym(List<String> words, String s) {
            int n = words.size();
            int m = s.length();
            if (m != n) return false;
            int i = 0; // words数组的索引
            int j = 0; // 字符串s的索引

            while (i < n && j < m) {
                if (words.get(i).charAt(0) == s.charAt(j)) {
                    i++; // 匹配成功，继续往下一个字符串匹配
                    j++; // 字符串s的索引也往后移动一位
                } else {
                    return false;
                }
            }

            return i == n && j == m; // 判断是否匹配到words数组的末尾和字符串s的末尾
        }


    }
}
