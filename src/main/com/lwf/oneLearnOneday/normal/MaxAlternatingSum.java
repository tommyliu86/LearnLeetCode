package com.lwf.oneLearnOneday.normal;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/7/11 8:29
 */
public class MaxAlternatingSum {
    /**
     * dp  ，万题皆可dp。考虑每个nums[i] 取或不取，取，则
     *
     */
    class Solution {
        public long maxAlternatingSum(int[] nums) {
            return 0l;
        }
    }
    /**
     * 模拟，要让值最大，需要偶>奇 ，类似于前缀和的概念，需要对序列是正向贡献，因此，我们使用两个常量空间保存，并且让收益最大，也就是奇数最小
     *
     */
    class Solution1 {
        public long maxAlternatingSum(int[] nums) {
            int even=nums[0],odd=Integer.MAX_VALUE,cur=1;
            int i=1;
            long ans=0;

            while (i<nums.length){
                if (cur==1){
                    if (nums[i]>=even) {
                        even=nums[i++];
                    }else{
                        cur++;
                        odd=nums[i++];
                    }
                }else{

                    if (nums[i]>odd){
                        ans+=even-odd;
                        even=nums[i++];
                        cur--;
                    }else if (nums[i]==odd ){
                        i++;
                    }else{
                        odd=nums[i++];
                    }
                }
            }
            return ans+even;
        }
    }
}
