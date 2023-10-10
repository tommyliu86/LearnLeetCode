package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/10/9 8:43
 */
public class SplitNum {
    /**
     * 1.转成数组，排序后从最大开始依次向最小值进行 加和 即可
     * 2.转成数组后，依次组合出两个 数字，直接相加。
     */
    class Solution {
        public int splitNum(int num) {
            String s = String.valueOf(num);
            int[] nums=new int[s.length()];
            for (int i = 0; i < nums.length; i++) {
                nums[i]=s.charAt(i)-'0';
            }
            Arrays.sort(nums);
            int ans=0;
            int step=0;
            int mark=1;
            for (int i = nums.length - 1; i >= 0; i-=2) {
                int i1 = nums[i] + (i > 0 ? nums[i - 1] : 0)+step;
                step=i1/10;
                i1%=10;
                ans+=i1*mark;
                mark*=10;
            }
            return step==0?ans:(ans+mark);
        }
    }
}
