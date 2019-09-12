package com.lwf;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * author Administrator
 * time 2019-08-16-0:09
 * {@link 453.md}
 */
public class MinMoves {
    public int minMoves(int[] nums){
        Arrays.sort(nums);
        int count=0; //移动的总步数
        int diff=0; //两个元素之间的差。也就是要移动的步数
        int precount=0;
        for (int i = 0; i <nums.length-1 ; i++) {
                diff    =nums[i+1]-nums[i]+count-precount ; //首先求相邻两个元素要多少步才能相等。由于i在之前移动了之前的总步数count，
            // 因此+count，但是这时有个问题是i-1自己也移动过count之前一次的次数，因此必须每次把i-1位置的数据+之前的count，
               precount=count;
                count+=diff;
        }
        return count;

    }
    public int minMoves1(int[] nums){

        int count=0; //移动的步数
        int minValue=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            count+=nums[i];
            minValue=Math.min(minValue,nums[i]);
        }
        return count-minValue*nums.length;

    }
}
