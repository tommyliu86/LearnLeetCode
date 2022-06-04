package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-02 09:55
 */
public class GetMaxLen {
    class Solution {
        public int getMaxLen(int[] nums) {
            int m=0;

            int up=0;
            int down=0;


            for (int i = 0; i < nums.length; i++) {
               if (up==0&&down==0){
                   if (nums[i]>0){
                       up++;
                   }
                   if (nums[i]<0){
                       down++;
                   }
               }else{
                   if (nums[i]>0){
                       up++;
                       down=down>0?down+1:0;
                   }else if (nums[i]<0){
                       int newup=down>0?down+1:0;
                       down=up>0?up+1:1;
                       up=newup;
                   }else{
                       up=0;
                       down=0;
                   }

               }
               m=Math.max(up,m);

            }
            return m;
        }
    }
}
