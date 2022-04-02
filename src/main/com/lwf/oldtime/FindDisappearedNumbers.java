package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-08-15-23:08
 * {@link 448.md}
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        new FindDisappearedNumbers().findDisappearedNumbers1(new int[]{
                4,3,2,7,8,2,3,1});
    }

    /**
     * 标记法，通过对元素位置进行标记，从而找出缺失的元素！
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[ (nums[i]-1)%nums.length]+=nums.length;
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=nums.length){
                list.add(i+1);
            }
        }
        return list;
    }

    /**
     * 桶排序后再进行一次遍历找出缺失的元素，没有标记法快
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                int a=i;
                int b=nums[i]-1;
                nums[a]=nums[a]^nums[b];
                nums[b]=nums[a]^nums[b];//通过异或实现原地交换
                nums[a]=nums[a]^nums[b];//通过异或实现原地交换
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1){
                list.add(i+1);
            }
        }
        return list;
    }
}
