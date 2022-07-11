package com.lwf.learn.everyday.quick;

public class TwoSum {
    class Solution1 {
        /**
         * 有序数组找两个数，使用双指针前后
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            int l=0;
            int r=numbers.length-1;
            while (l<r){
                int i = numbers[l] + numbers[r];
                if (i==target){
                    return new int[]{l+1,r+1};
                }else if (i<target){
                    l++;
                }else{
                    r++;
                }
            }
            return new int[] {0,0};
        }
    }
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] rtn=new int[2];
            for (int i = 0; i < numbers.length; i++) {
                int half = half(numbers, i + 1, numbers.length - 1, target - numbers[i]);
                if (target-numbers[i]==numbers[half]){
                    rtn[0]=i+1;
                    rtn[1]=half+1;
                    break;
                }
            }
            return rtn;
        }
        public int half(int[] nums,int l,int r,int t){
            while (l<r){
                int m=(l+r)/2;
                if (nums[m]==t){
                    return m;
                }else if (nums[m]<t){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            return l;
        }
    }
}
