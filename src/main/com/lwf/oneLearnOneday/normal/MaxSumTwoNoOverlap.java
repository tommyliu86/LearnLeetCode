package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/4/26 9:27
 */
public class MaxSumTwoNoOverlap {
    /**
     * 使用滑动窗口求一个子数组的长度和，然后使用二维数组记录0~i和j~length的两个部分中的最大值，这时我们就可以再用滑动窗口去求
     * 前+后中的最大+当前滑动窗口值，维护一个max做更新就是结果
     */
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int[][] matrix=new int[nums.length][nums.length+1];
            int sum=0;
            int i=0,j=0;
            int[] max=new int[nums.length];
            while (j<nums.length){
                sum+=nums[j];
                if (j-i+1==firstLen){
                    max[j]=sum;
                    matrix[0][j+1]=Math.max(matrix[0][j],sum);
                    sum-=nums[i++];
                }
                j++;
            }
            i=nums.length;
            matrix[i-firstLen][j]=max[i-1];
            while (--i-firstLen>=0){
                matrix[i-firstLen][j]=Math.max( matrix[i-firstLen+1][j],max[i-1]);
            }
            int ans=0;
            i=0;
            j=0;
            sum=0;
            while (j<nums.length){
                sum+=nums[j];
                if (j-i+1==secondLen){
                    ans=Math.max(sum+getMax(matrix,i,j,nums.length) ,ans);

                    sum-=nums[i++];
                }
                j++;
            }
            return ans;
        }
        private int getMax(int[][] matrix,int i,int j,int l){
            if (i==0){
                return matrix[j+1][l];
            }else if (j==l-1){
                return matrix[0][i-1];
            }else{
                return Math.max(matrix[0][i-1],matrix[j+1][l]);
            }
        }
    }
}
