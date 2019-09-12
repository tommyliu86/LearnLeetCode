package com.lwf;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] ints=new int[]{4,2,4,0,0,3,0,5,1,0};
       moveZeroes(ints);
    }
    /**
     * 1.交换位置法。如果使用头尾指针，进行直接交换，就涉及到被移动的元素如何回到原来顺序中的问题。因此不可取，思路不对
     *
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int left = 0;

        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] != 0) {
                left++;
                continue;
            }
            if (nums[right] == 0) {
                right--;
                continue;
            }
            list.add(left);
            nums[left] = nums[right];
            nums[right] = 0;
            right--;

        }
        while (!list.isEmpty() && list.get(0) < right-1) {
            for (int i = 0; i < Math.min(right - list.get(0), list.size()); i++) {
                int temp = nums[right];
                nums[right] = nums[list.get(i)];
                nums[list.get(i)] = temp;
                right--;
            }
        }
        if (!list.contains(right)){
            int temp = nums[right];
            nums[right] = nums[list.get(0)];
            nums[list.get(0)] = temp;
        }
    }

    /**
     * 双指针移动，遍历数组 while进行循环
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {

        int left = 0;
        int right = left + 1;
        while (left < nums.length - 1 && right < nums.length) {
            if (nums[left] != 0) {
                left++;

                continue;
            }
            if (right <= left) {
                right = left + 1;
            }
            if (nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
            right++;
        }
    }
    /**
     *滑动元素为0的子数组
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int cursor=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                int temp=nums[cursor];
                nums[cursor]=nums[i];
                nums[i]=temp;
                cursor++;
            }
        }
    }
}
