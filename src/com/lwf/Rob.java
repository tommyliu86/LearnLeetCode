package com.lwf;


/**
 * author Administrator
 * time 2019-07-25
 */
public class Rob {
    /**
     * 动态规划。第k个房间是否进来。取决于 fk-1 和fk-2 +k的值哪个大。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int first=0;
        int second=0;
        int thrid=0;
        for (int i = 0; i < nums.length; i++) {

             thrid=Math.max(first+nums[i],second);

            first=second;
            second=thrid;
        }
        return second;

    }
}
