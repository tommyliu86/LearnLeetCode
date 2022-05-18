package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-16-22:31
 * {@link 283.md}
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[pre++]=nums[i];
               if (pre!=i+1){   //判断往前选择排列非零元素时，是否已经出现过0了，如果出现过了。则pre和i的 ++是不同步的，因此这时候把i放到pre的位置上，需要把本身i位置上用零补齐。
                   //类似于选择排序，找到非零，往前放。
                   nums[i]=0;
               }
            }
        }
    }
}
