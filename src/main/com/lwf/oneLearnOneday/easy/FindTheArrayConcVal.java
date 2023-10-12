package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/10/12 9:14
 */
public class FindTheArrayConcVal {
    /**
     * 直接双指针遍历即可
     */
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            long ans=0;
            int i=0,j=nums.length-1;
            while (i<=j){
                if (i!=j){
                    int a=nums[i++]* lengths( nums[j])+nums[j--];
                    ans+=a;
                }else{
                    ans+=nums[i++];
                }
            }
            return ans;
        }
        public int lengths(int i){
            int ans =1;
            while (i!=0){
                i/=10;
                ans*=10;
            }
            return ans;
        }
    }
}
