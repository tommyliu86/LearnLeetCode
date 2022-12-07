package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/12/2 9:07
 */
public class MinOperations {
    public static void main(String[] args) {

        new Solution().minOperations(new int[]{3, 3, 2, 4, 2, 6, 2},
                new int[]{6, 2, 6, 6, 1, 1, 4, 6, 4, 6, 2, 5, 4, 2, 1});
    }

    static
    class Solution {
        /**
         * 单步双指针
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int minOperations(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) {
                return -1;
            }
            int sum1 = 0;
            int sum2 = 0;
            int[] count1 = new int[6];
            int[] count2 = new int[6];
            for (int i = 0; i < nums1.length; i++) {
                sum1 += nums1[i];
                count1[nums1[i]-1]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                sum2 += nums2[i];
                count2[nums2[i]-1]++;
            }
            if (sum1 == sum2) {
                return 0;
            }
            if (sum1 < sum2) {
                int temp = sum1;
                sum1 = sum2;
                sum2 = temp;
                int[] ints = count1;
                count1 = count2;
                count2 = ints;
            }
            int count=0;
            int gap=sum1-sum2;
            for (int i = 5; i > 0; i--) {
                int gap1 = i * count1[i];
                int gap2 = i * count2[5 - i];
                if (gap<=gap1+gap2){
                    count+=(gap/i )+(gap%i==0?0:1);
                    break;
                }else{
                    count+=count1[i]+count2[5 - i];
                }
                gap-=gap1+gap2;
            }
            return count;

        }

        /**
         * 单步双指针
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int minOperations2(int[] nums1, int[] nums2) {
            int sum1 = Arrays.stream(nums1).sum();
            int sum2 = Arrays.stream(nums2).sum();
            if (sum1 == sum2) {
                return 0;
            }
            if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) {
                return -1;
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            if (sum1 < sum2) {

            }
            int i1 = nums1.length - 1;
            int i2 = 0;
            int ans = 0;
            while (sum1 > sum2) {
                int gap1 = (i1 < 0 ? 0 : nums1[i1]) - 1;
                int gap2 = (i2 >= nums2.length ? -1 : 6 - nums2[i2]);
                if (gap1 >= gap2) {
                    i1--;
                    sum1 -= gap1;
                } else {
                    i2++;
                    sum2 += gap2;
                }
                ans++;
            }
            return ans;
        }

        /**
         * 如果是只变化nums1，这样求解
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int minOperations1(int[] nums1, int[] nums2) {
            int sums = Arrays.stream(nums2).sum();
            if (sums < nums1.length || sums > nums1.length * 6) {
                return -1;
            }
            Arrays.sort(nums1);
            int sub = sums - Arrays.stream(nums1).sum();
            int ans = 0;
            int i = sub > 0 ? 0 : (nums1.length - 1);
            int step = sub > 0 ? 1 : -1;
            while (sub != 0) {
                sub += ((step == 1 ? 6 : 1) - nums1[i]) * step;
                if (sub * step < 0) {
                    break;
                }
                i += step;
                ans++;
            }
            return ans + 1;
        }
    }

    /**
     * 计数，可以通过左右侧的‘1’的个数直接计算位移
     */
    class Solution2 {
        public int[] minOperations(String boxes) {
            int[] ans = new int[boxes.length()];
            //left 和right计算时要包括当前位置的数值到left中，这样在循环计算时直接使用left和right，因为从 i-》i+1，右侧的这个数也是计算在right计数中的
            int left = boxes.charAt(0) == '0' ? 0 : 1;
            int right = 0;
            for (int i = 1; i < boxes.length(); i++) {
                if (boxes.charAt(i) == '1') {
                    right += 1;
                    ans[0] += i;//计算初始
                }
            }

            for (int i = 1; i < ans.length; i++) {
                ans[i] = ans[i - 1] + left - right;
                if (boxes.charAt(i) == '1') {
                    left++;
                    right--;
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int[] minOperations(String boxes) {
            int[] ans = new int[boxes.length()];
            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < boxes.length(); i++) {
                if (boxes.charAt(i) == '1') {
                    indexes.add(i);
                }
            }
            for (int i = 0; i < ans.length; i++) {
                for (Integer index : indexes) {
                    ans[i] += Math.abs(index - i);
                }
            }
            return ans;
        }
    }
}
