package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/12/16 9:17
 */
public class MinElements {
    /**
     * 注意int的越界问题。。简单的加法
     */
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            long sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
            }
            long sub = sum - goal;
            if (sub == 0) {
                return 0;
            }
            long count = (Math.abs(sub) / limit)+(Math.abs(sub)%limit!=0?1:0);
            return (int) count;
        }
    }

    /**
     * 看错题了。。不是让元素变化大小来得到goal，而是添加元素。
     */
    class Solution1 {
        public int minElements(int[] nums, int limit, int goal) {

            Arrays.sort(nums);
            int sum = Arrays.stream(nums).sum();
            int sub = sum - goal;
            if (sub == 0) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            int ans = 0;
            while (sub != 0 && left < right) {
                if (sub > 0) {
                    sub -= nums[right] + limit;
                    ans++;
                    right--;
                    if (sub <= 0) {
                        break;
                    }
                } else {
                    sub += limit - nums[left];
                    ans++;
                    left++;
                    if (sub >= 0) {
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
