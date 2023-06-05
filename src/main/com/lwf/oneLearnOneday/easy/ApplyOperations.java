package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/6/5 8:46
 */
public class ApplyOperations {
    /**
     * 遍历+双指针
     */
    class Solution {
        public int[] applyOperations(int[] nums) {
            //遍历数组,索引从0到长度-1
            for (int i = 0; i < nums.length-1; i++) {
                //如果两个相邻数字相等
                if (nums[i]==nums[i+1]){
                    //将它们相加,并将和存储在第一个数字中
                    nums[i]+=nums[i+1];
                    //将第二个数字设置为0
                    nums[i+1]=0;
                }
            }
            //初始化两个指针i和j
            int i=0,j=0;
            //从索引0开始遍历数组
            while (j<nums.length){
                //如果指针j处的数字不为0
                if (nums[j] != 0) {
                    //交换指针i和j处的数字
                    int tmp=nums[i];
                    nums[i] = nums[j];
                    nums[j]=tmp;
                    //向前移动指针i
                    i++;
                }
                //向前移动指针j
                j++;
            }
            //返回修改后的数组
            return nums;
        }
    }
}
