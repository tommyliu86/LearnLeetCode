package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-21 17:47
 */
public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
           int left=0;
           int right=nums.length-1;
           int i=0;
           while (i<=right){
               if (nums[i]==0){
                   if (i==left){ //两个节点在一起，则一起移动到下一个
                       left++;
                       i++;
                   }else{ //否则，进行交换，把i的值放到left，这时需要再次查看i的值 1，0，2，这时 i=1，left=0；


                       int temp=nums[left];
                       nums[left]=nums[i];
                       nums[i]=temp;
                       left++;

                   }

               }else if (nums[i]==2){
                   int temp=nums[right];
                   nums[right]=nums[i];
                   nums[i]=temp;
                   right--;
               }else{
                   i++;
               }
           }

        }
    }
}
