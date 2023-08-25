package com.lwf.data;

import java.util.Arrays;

/**
 * 数位dp，数位DP
 * @author liuwenfei
 * @date 2023/3/20 16:30
 */
public class NumberDP {
    class Solution {
        char s[];
        int dp[][];

        public int numDupDigitsAtMostN(int n) {
            s = Integer.toString(n).toCharArray();
            int m = s.length;
            //使用dp数组，保存目前位置i可以取0~9的每一位的不重复总数。因此应该是从小到大的可以记忆化的数据
            dp = new int[m][1 << 10];
            for (int i = 0; i < m; i++)
                Arrays.fill(dp[i], -1); // -1 表示没有计算过
            return n - f(0, 0, true, false);
        }

        /**
         *
         * @param i 当前第i位选择数字
         * @param mask mask中使用二进制方法记录0~9的数字是否已经使用过,二进制得第i位表示0--9得第几个数字！，
         * @param isLimit 当前的dp中组合成的数字是否收到n的约束，也就是当前取得所有数字恰好==n得前i位，起始为true，因为第前置位为0，
         * @param isNum 表示当前组合是否全部都是前导0得情况，若位true，表示不是全部前导0，false表示都是前导0
         * @return
         */
        int f(int i, int mask, boolean isLimit, boolean isNum) {
            if (i == s.length)
                return isNum ? 1 : 0; // isNum 为 true 表示得到了一个合法数字
            if (!isLimit && isNum && dp[i][mask] != -1)
                return dp[i][mask];
            int res = 0;
            if (!isNum){
                // 可以跳过当前数位，都是前导0
                res = f(i + 1, mask, false, false);
            }
            int up = isLimit ? s[i] - '0' : 9; // 如果前面填的数字都和 n 的一样，那么这一位至多填数字 s[i]（否则就超过 n 啦）
            for (int d = isNum ? 0 : 1; d <= up; ++d) // 枚举要填入的数字 d
                if ((mask >> d & 1) == 0) // d 不在 mask 中
                    res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            if (!isLimit && isNum)
                dp[i][mask] = res;
            return res;
        }
    }


    static
    class Solution1 {
        int[][] dp;
        char[] chars;
        public int numDupDigitsAtMostN(int n) {
            chars=String.valueOf(n).toCharArray();
            //1<<10表示得是0-9得数字组合，只要某一种组合出现过，后续不需要再次计算。
            dp=new int[chars.length][1<<10];
            for (int i = 0; i < dp.length; i++) {
                //-1表示没有计算过，记忆化
                Arrays.fill(dp[i],-1);
            }
            return n  - counts(0, 0, true,false);
        }

        /**
         * 数位dp标准的dfs函数，通过位数i，标记mark来进行逐位计算，isLimit来区分是否是收到原数约束的情况，isNum则是前导零的情况。
         *
         * @param i
         * @param marks
         * @param isLimit
         * @param isNum
         * @return
         */
        public int counts(int i, int marks,boolean isLimit,boolean isNum) {
            //dfs到最后，如果isNum不是全部前导0，表示marks的组合肯定是可用的，则需要返回1表示当前的组合
            if (i >= chars.length) return isNum?1:0;
            //只有不是Limit且有数据IsNum才会放入dp中来做记忆化
            if (!isLimit&&isNum&&dp[i][marks]!=-1){
                return dp[i][marks];
            }
            int ans = 0;
            //如果全部前导零，则可以继续前导零，这里直接进行单独计算
            if (isNum==false){
                ans+=counts(i+1,marks,false,isNum);
            }
            int max=isLimit?(chars[i]-'0'):9;
            //这里的起始位置需要考虑isNum，如果还没有填写过数字，则要从1开始，因为全部前导0的情况在上面已经包括过了
            for (int j = isNum?0:1; j <= max; j++) {
                if ((marks&(1<<j))==0){
                    ans+=counts(i+1,marks|(1<<j),isLimit&&j==max,true);
                }
            }
            //添加到dp中做记忆化
            if (!isLimit&&isNum){
                dp[i][marks]=ans;
            }
            return ans;
        }
    }
}
