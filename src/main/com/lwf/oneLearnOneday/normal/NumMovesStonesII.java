package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/4/7 9:05
 */
public class NumMovesStonesII {
    //3479
    class Solution {
        public int[] numMovesStonesII(int[] stones) {
            int[] ans=new int[2];
            Arrays.sort(stones);
            int l = stones.length;
            int gap = stones[l - 1] - stones[0] + 1 - l;
            if (gap==0) return ans;
            ans[1]=Math.max(gap-(stones[1]-stones[0]-1),gap-(stones[l-1]-stones[l-2]-1));
            int mi = l;
            //滑动窗口，从stones中找到两个下标 i，j，这两个之间的长度就是窗口大小，在这里面就是
            for (int i = 0, j = 0; i < l && j + 1 < l; ++i) {
                //右指针找到定位
                while (j + 1 < l && stones[j + 1] - stones[i] + 1 <= l) {
                    ++j;
                }
                //进行计算当前的需要移动的次数
                if (j - i + 1 == l - 1 && stones[j] - stones[i] + 1 == l - 1) {
                    mi = Math.min(mi, 2);
                } else {
                    mi = Math.min(mi, l - (j - i + 1));
                }
            }
            ans[0]=mi;
            return ans;


        }
    }
}
