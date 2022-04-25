package com.lwf.arithmetic.level2.arrayandstring;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-24 18:30
 */
public class IncreasingTriplet {
    class Solution {
        /**
         * 两个临时元素保存第一个和第二个，只要存在元素大于第二个，就成立。是递增数列判断的应用
         *
         * @param nums
         * @return
         */
        public boolean increasingTriplet2(int[] nums) {

            int l = 0;
            for (int i = 0; i < nums.length; i++) {
                if (l == 0) {
                    nums[l++] = nums[i];
                } else {
                    int curN = nums[i];

                    if (nums[0] >= curN) {
                        nums[0] = curN;
                    } else if (l == 1) {
                        nums[1]=curN;
                        l++;
                    }else{
                        if (nums[1]<curN){
                            return true;
                        }else if (nums[1]>curN){
                            nums[1]=curN;
                        }
                    }
                }
            }
            return false;
        }

        /**
         * 两个临时元素保存第一个和第二个，只要存在元素大于第二个，就成立。是递增数列判断的应用
         *
         * @param nums
         * @return
         */
        public boolean increasingTriplet1(int[] nums) {
            int[] min = new int[2];
            int l = 0;
            for (int i = 0; i < nums.length; i++) {
                if (l == 0) {
                    min[l++] = nums[i];
                } else {
                    int curN = nums[i];
                    if (min[l - 1] == curN || min[0] == curN) {
                        continue;
                    }
                    if (min[0] > curN) {
                        min[0] = curN;
                    } else if (l == 1) {
                        min[l++] = curN;
                    } else if (min[1] < curN) {
                        return true;
                    } else {
                        min[1] = curN;
                    }
                }
            }
            return false;
        }

        /**
         * 辅助空间保存元素i为结尾的数列长度，每次取i+1时，需要与0~i进行比较，找到最长数列。
         *
         * @param nums
         * @return
         */
        public boolean increasingTriplet(int[] nums) {

            int[] maxL = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int max = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        max = Math.max(maxL[j] + 1, max);
                    }
                }
                if (max < 3) {
                    maxL[i] = max;
                } else {
                    return true;
                }
            }
            return false;
        }

        /**
         * 使用辅助数组保存末尾使用当前index=i处的递增数组的最大长度，遍历到j时，查找前面的j-1的所有元素和j比较，如果增加，则记录长度，并记录到
         * 辅助数组中
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS(int[] nums) {
            int[] maxl = new int[nums.length];
            int maxLength = 0;
            for (int i = 0; i < nums.length; i++) {
                int max = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && maxl[j] + 1 > max) {
                        max = maxl[j] + 1;
                    }
                }
                maxl[i] = max;
                maxLength = Math.max(maxLength, max);
            }

            return maxLength;
        }

        /**
         * 使用辅助数组保存长度为i的升序的最小尾数。遍历数组，i处的N可以在辅助数组中找到比N小的最长长度i，更新i+1处的尾数为N，遍历到最后，即可获取到
         * 辅助数组的长度就是升序最大值。
         * <p>
         * 辅助数组中
         *
         * @param nums
         * @return
         */
        public int lengthOfLIS1(int[] nums) {
            int[] minN = new int[nums.length];
            int maxI = 0;
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                if (maxI == 0) {
                    minN[maxI] = cur;
                    maxI++;
                } else {
                    if (minN[maxI - 1] == cur || minN[0] == cur) {
                        continue;
                    }
                    if (minN[maxI - 1] < cur) {
                        minN[maxI++] = cur;
                    } else if (minN[0] > cur) {
                        minN[0] = cur;
                    } else {
                        int j = find(minN, 0, maxI - 1, cur);
                        if (minN[j] == cur) {
                            continue;
                        } else if (minN[j] > cur) {
                            minN[j] = cur;
                        } else {
                            minN[j + 1] = cur;
                        }
                    }
                }
            }
            return maxI;
        }

        /**
         * 二分查找的细节
         *
         * @param minN
         * @param left
         * @param right
         * @param target
         * @return
         */
        public int find(int[] minN, int left, int right, int target) {
            if (left >= right) {
                return left;
            }
            int mid = (left + right) / 2;
            if (minN[mid] == target) {
                return mid;
            }
            if (minN[mid] > target) {
                return find(minN, left, mid - 1, target);
            } else {
                return find(minN, mid + 1, right, target);
            }
        }
    }
}
