package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuwenfei
 * @date: 2024/4/22-9:00
 */
public class CombinationSum4 {
    /**
     * 1.组合的sum=target，根据题目要求可以使用dp，把问题分解成子问题进行求解，
     * 2.抽屉原理，每个元素可以使用多次，那么这样的话，我们需要先使用dp构建出一个每个t对应的组合可能，对于每个sum【t】，我们遍历添加nums的元素，看当前能否放入这个元素组合成目标值
     */
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            //和为index的组合数量，初始值为0
            int[] sums = new int[target + 1];
            //设置和为0的数量为1，这样当num本身==index时，可以实现计数
            sums[0]=1;
            for (int i = 0; i < sums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    int num = nums[j];
                    sums[i]+=i-num>=0?sums[ i-num]:0;
                }
            }
            return sums[target];

        }
    }
}
