package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-19 11:36
 */
public class LengthOfLIS {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] len = new int[nums.length];
            int l = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (l == 0) {
                    len[l++] = num;
                } else {
                    if (len[l - 1] < num) {
                        len[l++] = num;
                    } else if (len[0] > num) {
                        len[0] = num;
                    } else {
                        int half = half(len, 0, l - 1, num);
                        if (len[half] < num) {
                            len[half + 1] = num;
                        } else {
                            len[half] = num;
                        }
                    }
                }
            }
            return l;
        }

        public int half(int[] len, int l, int r, int t) {
            if (l >= r) {
                return l;
            }
            int m = (l + r) / 2;
            if (len[m] == t) {
                return m;
            } else if (len[m] > t) {
                return half(len, l, m - 1, t);
            } else {
                return half(len, m + 1, r, t);
            }
        }
    }
}
