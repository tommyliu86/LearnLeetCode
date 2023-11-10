package com.lwf.offer.two;

/**
 * LCR 070. 有序数组中的单一元素
 * @author liuwenfei
 * @date 2023/11/9 18:41
 */
public class SingleNonDuplicate {
    /**
     * 二分查找
     * 查找 m，如果m/2==0 && f（m）==f（m-1） 则在右边，否则在左边
     * 计算 中间值m ，m奇数则 m--，保证m是偶数，每次移动i=m+2 保证i是偶数，j=m-1 保证j是奇数，因此
     * 我们可以知道最终会是  j+1=i的状态，i就是要找的值。
     *
     */
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int i=0,j=nums.length-1;
            while (i<j){
                //m 偶数，i偶数，j 奇数
                int m=i+(j-i)/2;
                if ((m&1)==1)
                    m--;
                if (nums[m]==nums[m+1]){
                    i=m+2;
                }else{
                    j=m-1;
                }
            }
            return nums[i];
        }
    }
}
