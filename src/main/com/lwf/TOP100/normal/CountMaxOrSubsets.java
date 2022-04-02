package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * 2044. 统计按位或能得到最大值的子集数目
 * @author: liuwenfei14
 * @date: 2022-03-17 18:18
 */
public class CountMaxOrSubsets {
    /**
     * 递归回溯 ，每个元素都有选择和不选择两种情况，找到所有分支进行计算即可
     * @param nums
     * @return
     */
    public int countMaxOrSubsets(int[] nums) {
        dp(nums,0,0);
        return count;
    }
    private int max=0;
    private int count=0;
    private void dp(int[] nums,int curIndex,int orNum){
        if (curIndex>=nums.length){
            if (orNum>max) {
                max=orNum;
                count=1;
            }else if(orNum==max){
                count++;
            }
            return;
        }
        dp(nums,curIndex+1,orNum);//没选择curIndex。
        dp(nums,curIndex+1,orNum|nums[curIndex]);
    }

}
