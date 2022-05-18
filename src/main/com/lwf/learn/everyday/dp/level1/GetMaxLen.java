package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 15:24
 */
public class GetMaxLen {
    public static void main(String[] args) {
        new Solution().getMaxLen(new int[]{1,-2,-3,4});
    }
  static  class Solution {
        public int getMaxLen(int[] nums) {
            int pos=0;
            int nag=0;
            int max=0;
            for (int i = 0; i < nums.length; i++) {

                if (nums[i]==0){
                    pos=0;
                    nag=0;
                }else{
                    if (nag==0&&pos==0) {
                        if (nums[i]>0){
                            pos++;
                        }else{
                            nag++;
                        }
                    }else if (nums[i]>0) {
                        pos++;
                        nag=(nag==0?0:(nag+1));
                    }else{

                       int npos=(nag==0?0:(nag+1));
                       int nnag=pos+1;
                       pos=npos;
                       nag=nnag;
                    }
                }
                max=Math.max(pos,max);
            }
            return max;
        }
    }
}
