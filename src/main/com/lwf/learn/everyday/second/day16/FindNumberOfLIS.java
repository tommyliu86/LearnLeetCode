package com.lwf.learn.everyday.second.day16;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-28 10:58
 */
public class FindNumberOfLIS {

    class test {
        public int findNumberOfLIS(int[] nums) {
            int[] l = new int[nums.length];
            int[] c = new int[nums.length];
            int ml = 0;
            int cl = 0;
            for (int i = 0; i < nums.length; i++) {
                l[i] = 1;
                c[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        if (l[i] < l[j] + 1) {
                            l[i] = l[j] + 1;
                            c[i] = c[j];
                        } else if (l[i] == l[j] + 1) { //最长长度可以出现的多种组合
                            c[i] += c[j];
                        }
                    }
                }
                if (ml < l[i]) {
                    ml = l[i];
                    cl = c[i];
                } else if (ml == l[i]) {
                    cl += c[i];
                }
            }
            return cl;
        }
    }

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] count = new int[nums.length];
            int[] l = new int[nums.length];
            int lmax = 0;
            int lcount = 0;
            for (int i = 0; i < nums.length; i++) {

                l[i] = 1;
                count[i] = 1;

                for (int j = i - 1; j >= 0; j--) {

                    if (nums[j] < nums[i]) {
                        if (l[i] < l[j] + 1) {

                            l[i] = l[j] + 1;
                            count[i] = count[j];
                        } else if (l[i] == l[j] + 1) {
                            count[i] += count[j];
                        }

                    }
                }

                if (l[i] > lmax) {
                    lmax = l[i];
                    lcount = count[i];
                } else if (l[i] == lmax) {
                    lcount += count[i];
                }

            }

            return lcount;
        }

    }
}
