package com.lwf.oneLearnOneday.normal;

/**
 * 2698. 求一个整数的惩罚数
 * https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/?envType=daily-question&envId=2023-10-25
 *
 * @author liuwenfei
 * @date 2023/10/25 9:04
 */
public class PunishmentNumber {
    public static void main(String[] args) {
        System.out.println(Solution.gt(10 * 10, 10, 0));
    }

    /**
     * 回溯 计算不同数字组合的和
     */
    class Solution {
        public int punishmentNumber(int n) {
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (gt(i * i, i, 0)) {
                    ans += i * i;
                }
            }
            return ans;
        }

        //枚举 把数字进行不同的切分，从尾部进行切分，sub（i，n） 不用继续分，sub(0,i-1) 需要不同的组合。
        public static boolean gt(int i, int t, int total) {
            if (i == 0) {
                return t == total;
            }
            if (i + total == t) {
                return true;
            }
            int j = 10;
            while (i / j > 0) {
                int sum = i % j;
                if (total + sum > t) {
                    break;
                }
                if (gt(i / j, t, total + sum)) {
                    return true;
                }
                j *= 10;
            }
            return false;
        }
    }
}
