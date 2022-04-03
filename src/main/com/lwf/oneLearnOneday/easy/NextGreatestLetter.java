package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 *
 * @author: liuwenfei14
 * @date: 2022-04-03 08:24
 */
public class NextGreatestLetter {
    /**
     * 二分查找
     */
    class test {
        /**
         * 数组有序，因此使用二分查找法
         *
         * @param letters
         * @param target
         * @return
         */
        public char nextGreatestLetter1(char[] letters, char target) {
            if (letters[letters.length-1]<=target){
                return letters[0];
            }
            int left=0;
            int right=letters.length;

            while (left<right){
                int mid=left+(right-left)/2;
                if (letters[mid]>target){
                    right=mid; //特殊逻辑，不-1，因为最后要找的是target的最近的大于，因此如果使用mid-1，假如刚好mid-1=target了，就会找到最后的一个值是等于target的，不能直接返回
                }else{ //小于等于的时候，需要继续向后查找，直到找到最接近 第一个大于target的数
                    left=mid+1;
                }

            }

            return letters[left];


//            while (left<right){
//                int mid=left+(right-left)/2;
//                if (letters[mid]>target){
//                    right=mid-1; //特殊逻辑，不-1，因为最后要找的是target的最近的大于，因此如果使用mid-1，假如刚好mid-1=target了，就会找到最后的一个值是等于target的，不能直接返回
//                }else{ //小于等于的时候，需要继续向后查找，直到找到最接近 第一个大于target的数
//                    left=mid+1;
//                }
//
//            }
//
//                return letters[left]<=target?letters[left+1]:letters[left];


        }
    }

    /**
     * 数组遍历
     */
    class Solution {
        /**
         * 数组有序，因此直接遍历查找，找到第一个>target的即可。若找不到则返回0的char
         *
         * @param letters
         * @param target
         * @return
         */
        public char nextGreatestLetter1(char[] letters, char target) {
            int left = 0;
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] > target) {
                    left = i;
                    break;
                }
            }
            return letters[left];
        }

        /**
         * 基于数组有序的查找方法。不够简洁
         *
         * @param letters
         * @param target
         * @return
         */
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;

            while (left < letters.length && letters[left] < target) {
                ++left;

            }
            if (left >= letters.length) {
                return letters[0];
            } else if (letters[left] == target) {
                int right = left;

                while (right < letters.length && letters[right] == target) {
                    right++;
                }
                if (right == letters.length) {
                    return letters[0];
                } else {
                    return letters[right];
                }
            } else {
                return letters[left];
            }
        }
    }
}
