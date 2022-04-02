package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-21 Time: 09:10
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int curmin=1;
        int curmax=1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                int temp=curmax;
                curmax=curmin   ;
                curmin=temp;
            }
            curmin=Math.min(curmin*nums[i],nums[i]); //cur表示包含当前i节点的最小sum
            curmax=Math.max(curmax*nums[i],nums[i]);//curmax表示包含当前i节点的最大sum。
            max= Math.max(max,curmax); //保存当前i时最大的乘积
        }
        return max;
    }
}
