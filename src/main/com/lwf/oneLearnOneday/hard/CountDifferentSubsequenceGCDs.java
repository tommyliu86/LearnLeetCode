package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/1/15 9:21
 */
public class CountDifferentSubsequenceGCDs {
    /**
     * 思路，逆向枚举，
     * 通过把所有的元素记录下来，然后从1到max进行枚举，如果有当前的i是元素的gcd中存在的，就ans++；
     *
     */
    class Solution {
        public int countDifferentSubsequenceGCDs(int[] nums) {
            int maxVal = Arrays.stream(nums).max().getAsInt();
            boolean[] occured = new boolean[maxVal + 1];
            for (int num : nums) {
                occured[num] = true;
            }
            int ans = 0;
            for (int i = 1; i <= maxVal; i++) {
                int subGcd = 0;
                for (int j = i; j <= maxVal; j += i) {
                    if (occured[j]) {
                        if (subGcd == 0) {
                            subGcd = j;
                        } else {
                            subGcd = gcd(subGcd, j);
                        }
                        if (subGcd == i) {
                            ans++;
                            break;
                        }
                    }
                }
            }
            return ans;
        }

        public int gcd(int num1, int num2) {
            return num1!=0?gcd(num2%num1,num1):num2;
        }
    }

}
