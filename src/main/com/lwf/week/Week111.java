package com.lwf.week;

import java.util.Arrays;
import java.util.List;

public class Week111 {

    class Solution {
        private char s[];
        private int memo[][][];
        int k;

        public int numberOfBeautifulIntegers(int low, int high, int k) {
            this.k = k;
            return calc("" + high) - calc("" + (low - 1));
        }

        int[] pow = new int[]{1, 10, 100, 1000, 10000, 100000, 1000_000, 10_000_000, 100_000_000, 1000_000_000};

        private int calc(String s) {
            this.s = s.toCharArray();
            int m = s.length();
            memo = new int[m][22][22];

            for (int i = 0; i < m; i++)
                for (int j = 0; j < 22; j++)
                    Arrays.fill(memo[i][j], -1); // -1 表示没有计算过

            int re = f(0, 0, 0, true, false);
            return re;
        }

        /**
         *
         * @param i 表示从前向后 从左到右边的 第i位
         * @param preMod
         * @param balance
         * @param isLimit 表示 前面 0~i-1 是否都是限制的数字，true 表示都是限制的，则只能选 0~limit(i)
         * @param isNum 表示前面 0~i-1 是否填了数字，false 表示前面都是空，那就可以继续是空 或 取值；true 表示前面有数字，则i 必须取值
         * @return
         */
        private int f(int i, int preMod, int balance, boolean isLimit, boolean isNum) {
            if (i == s.length)
                return (isNum && preMod == 0 && balance == 0) ? 1 : 0; // isNum 为 true 表示得到了一个合法数字

            if (!isLimit && isNum && memo[i][preMod][balance + 11] != -1)
                return memo[i][preMod][balance + 11];
            int res = 0;
            if (!isNum) // 可以跳过当前数位
                res = f(i + 1, preMod, balance, false, false);
            int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 s 的一样，那么这一位至多填数字 s[i]（否则就超过 s 啦）
            for (int d = isNum ? 0 : 1; d <= up; d++) { // 枚举要填入的数字 d
                //偶数 1 奇数-1
                int tmpBalance = d % 2 == 0 ? -1 : 1;
                //当前的前面位数组成的数，比如 123456789 ，在i==2时，preMode=12000000
                int tmpPreMod = preMod + pow[s.length - i - 1] * d;
                tmpPreMod %= k;
                res = (res + f(i + 1, tmpPreMod, balance + tmpBalance, isLimit && d == up, true));
            }
            if (!isLimit && isNum)
                memo[i][preMod][balance + 11] = res;
            return res;
        }


    }

    class Solution4 {
        public int numberOfBeautifulIntegers(int low, int high, int k) {

            int count = 0;
            int i = k;
            if (i < low) {
                i = (low / k) * k + ((low % k == 0) ? 0 : k);
            }
            for (; i <= high; i += k) {
                if (check(i)) {
                    count++;
                }
            }
            return count;
        }

        public boolean check(int num) {

            String nStr = String.valueOf(num);
            if (nStr.length() % 2 != 0) {
                return false;
            }
            int even = 0;
            int odd = 0;
            for (char c : nStr.toCharArray()) {
                if (c % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            return even == odd;
        }
    }

    class Solution3 {
        public int minimumOperations(List<Integer> nums) {
            int[] dp = new int[3];

            for (int i = 0; i < nums.size(); i++) {
                Integer cur = nums.get(i);
                if (cur == 1) {
                    dp[1]++;
                    dp[2]++;
                } else if (cur == 2) {

                    dp[1] = Math.min(dp[0], dp[1]);
                    dp[0]++;
                    dp[2]++;
                } else {
                    dp[2] = Math.min(dp[2], Math.min(dp[1], dp[0]));
                    dp[0]++;
                    dp[1]++;
                }

            }
            return Math.min(dp[0], Math.min(dp[1], dp[2]));
        }
    }

    class Solution2 {
        public boolean canMakeSubsequence(String str1, String str2) {
            if (str1.length() < str2.length()) return false;
            int i1 = 0, i2 = 0;
            boolean ans = true;
            while (i1 < str1.length() && i2 < str1.length() && ans) {
                if (str1.length() - i1 < str2.length() - i2) {
                    ans = false;
                    break;
                }
                char cur = str1.charAt(i1);
                if (cur == str2.charAt(i2) || ('a' + ((cur + 1 + 26 - 'a') % 26) == str2.charAt(i2))) {
                    i2++;
                }
                i1++;
            }
            if (ans && i2 == str2.length()) {
                return true;
            } else {
                return false;
            }
        }
    }

    class Solution1 {
        public int countPairs(List<Integer> nums, int target) {
            nums.sort(Integer::compareTo);
            if (nums.size() <= 1 || nums.get(0) + nums.get(1) >= target) {
                return 0;
            }
            int ans = 0;
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i + 1; j < nums.size(); j++) {
                    if (nums.get(i) + nums.get(j) < target) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
