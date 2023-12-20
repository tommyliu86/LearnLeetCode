package com.lwf.oneLearnOneday.normal;

/**
 * 162. 寻找峰值
 * @author liuwenfei
 * @date 2023/12/18 19:32
 */
public class FindPeakElement {
    /**
     * 二分查找
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            int l=0,r=nums.length-1;
            //m<r成立，因此我们用m与m+1比较
            while (l<r){
                int m=l+(r-l)/2;
                if (nums[m]>nums[m+1]){
                    r=m;
                }else{
                    l=m+1;
                }
            }
            return l;
        }

    }
}
