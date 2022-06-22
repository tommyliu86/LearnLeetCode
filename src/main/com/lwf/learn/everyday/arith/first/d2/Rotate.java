package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 14:10
 */
public class Rotate {
    //用计数器记录交换了多少个节点了
    class Solution2 {
        public void rotate(int[] nums, int k) {
            int n=nums.length;
            int count=0;
            for (int i = 0;count<n&& i < (i+k)%n; i++) {
                int newi=(i+k)%n;
                int temp=nums[i];
                while (newi!=i){
                    count++;
                    int t = nums[newi];
                    nums[newi]=temp;
                    temp=t;
                    newi=(newi+k)%n;
                }
                nums[i]=temp;
                count++;
            }
        }

    }
    class Solution1 {
        public void rotate(int[] nums, int k) {
            int[] rtn=new int[nums.length*2];
            for (int i = 0; i < rtn.length; i++) {
               rtn[i]=nums[i%nums.length];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i]=rtn[i+nums.length- k%nums.length];
            }
        }
    }
    class Solution {
        public void rotate(int[] nums, int k) {
            int[] rtn=new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int newi=(i+k)%nums.length;
                rtn[newi]=nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i]=rtn[i];
            }
        }
    }
}
