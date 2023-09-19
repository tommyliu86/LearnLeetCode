package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/9/19 8:45
 */
public class Rob4 {
    /**
     * 看到「最大化最小值」或者「最小化最大值」就要想到二分答案，这是一个固定的套路。
     * <p>
     * 假设要偷取的房屋最大值是 y ， 则 在偷取时，大于y的不要，同时我们要尽可能多的偷，这样才能偷够k个。
     * 因此 f(y) 表示 最大值是y时，能偷盗的房屋数量，f(y)>=k  则可行，因此该题变成了二分查找。。
     */
    class Solution {
        public int minCapability(int[] nums, int k) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            while (min < max) { //开区间二分查找
                int mid = (min + max) / 2;
                if (find(mid, nums) >= k) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return max;
        }

        /**
         * 两个常量 的 dp写法
         *
         * @param mx
         * @param nums
         * @return
         */
        private int find(int mx, int[] nums) {
            //fpre表示i-1可以选取的最大，fcur表示i可以选取的最大，
            int fpre = 0, fcur = 0;
            for (int x : nums) {
                if (x > mx) { //滚动向前，当前 元素不选，则 fcur保持不变，fpre就会和fcur相等了
                    fpre = fcur;
                } else {
                    int tmp = fcur;
                    fcur = Math.max(fcur, fpre + 1);
                    fpre = tmp;
                }
            }
            return fcur;
        }
    }

    class Solution1 {
        public int minCapability(int[] nums, int k) {
            int left = 0, right = 0;
            for (int x : nums) {
                right = Math.max(right, x);
            }
            //灵神的这种写法，适用于明确的left<可用范围时，因为假如left有可能是答案，则left+1=right时就会终止查找，
            while (left + 1 < right) { // 开区间写法
                int mid = (left + right) >>> 1;
                if (check(nums, k, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(int[] nums, int k, int mx) {
            int f0 = 0, f1 = 0;
            for (int x : nums) {
                if (x > mx) {
                    f0 = f1;
                } else {
                    int tmp = f1;
                    f1 = Math.max(f1, f0 + 1);
                    f0 = tmp;
                }
            }
            return f1 >= k;
        }
    }


}
