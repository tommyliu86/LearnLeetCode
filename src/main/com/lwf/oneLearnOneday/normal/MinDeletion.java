package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.List;

/**
 * 2216. 美化数组的最少删除数
 *
 * @author liuwenfei
 * @date 2023/11/21 9:12
 */
public class MinDeletion {
    /**
     * 栈  模拟
     */
    class Solution {
        public int minDeletion(int[] nums) {
            List<Integer> stack=new LinkedList<>();
            int i=0;
            while (i<nums.length){
                if (stack.size()%2==0){
                    stack.add(nums[i++]);
                }else{
                    while (i<nums.length&&stack.get(stack.size()-1)==nums[i]){
                        i++;
                    }
                    if (i<nums.length){
                        stack.add(nums[i++]);
                    }
                }
            }
            return nums.length-( stack.size()-(stack.size()%2));
        }
    }

    /**
     * 双指针 遍历，遍历时统计所有 f(i)==f(i+1）且需要移除的元素个数即可
     */
    class Solution1 {
        public int minDeletion(int[] nums) {
            int i = 0;
            int ans = 0;
            while (i < nums.length) {
                if (((i - ans) % 2) == 0) {
                    int j = i + 1;

                    while (j < nums.length && nums[j] == nums[i]) {
                        j++;
                        ans++;
                    }
                    if (j == nums.length) {
                        ans++;
                    }
                    i = j;

                }
                i++;
            }
            return ans;
        }
    }
}
