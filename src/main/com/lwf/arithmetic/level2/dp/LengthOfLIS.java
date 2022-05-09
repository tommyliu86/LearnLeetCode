package com.lwf.arithmetic.level2.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-09 17:55
 */
public class LengthOfLIS {
    class test {
        public int lengthOfLIS(int[] nums) {
            int[] end=new int[nums.length];
            end[0]=nums[0];
            int i=1;
            for (int j = 1; j < nums.length; j++) {
                int cur = nums[j];
                if (cur>end[i-1]){
                    end[i]=cur;
                    i++;
                }else{
                    int half = half(end, 0, i - 1, cur);
                    if (end[half]>=cur){
                        end[half]=cur;
                    }else{
                        end[half+1]=cur;
                    }
                }

            }
            return i;
        }
        public int half(int[] nums,int left,int right,int t){
            if (left>=right){
                return left;
            }
            int mid=(left+right)/2;
            if (nums[mid]==t){
                return mid;
            }else if (nums[mid]>t){
                return half(nums,left,mid-1,t);
            }else{
                return half(nums,mid+1,right,t);
            }
        }
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] l = new int[nums.length];

            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                int length = 1;
                int pre = i - 1;
                while (pre >= 0) {
                    if (nums[pre] < nums[i]) {
                        length = Math.max(length, l[pre] + 1);
                    }
                    pre--;
                }
                l[i] = length;
                max = Math.max(max, l[i]);
            }
            return max;
        }
    }
}
