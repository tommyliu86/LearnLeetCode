package com.lwf.TOP100;

import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-03-23:57
 * {@link 4.md}
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        int count = 0;
        int end;

        boolean odd = ((nums1.length + nums2.length) & 1) == 1;
        if (odd) {
            end = (nums1.length + nums2.length) / 2;
        } else {
            end = (nums1.length + nums2.length) / 2 - 1;
        }
        while (n1 < nums1.length && n2 < nums2.length && count < end) {
            if (nums1[n1] <= nums2[n2]) {
                n1++;
            } else {
                n2++;
            }
            count++;
        }
        if (count == end) {
            if (n1 == nums1.length || n2 == nums2.length) {
                return odd ? (n1 == nums1.length ? nums2[n2] : nums1[n1]) : (n1 == nums1.length ? ((double) nums2[n2] + nums2[n2 + 1]) / 2 : ((double) nums1[n1] + nums1[n1 + 1]) / 2);
            } else {
                return odd ? (nums1[n1] > nums2[n2] ? nums2[n2] : nums1[n1]) : ((double) nums1[n1] + nums2[n2]) / 2;
            }
        } else {
            if (n1 == nums1.length) {
                return odd ? nums2[n2 + end - count] : ((double) nums2[n2 + end - count] + nums2[n2 + end - count + 1]) / 2;
            } else {
                return odd ? nums1[n1 + end - count] : ((double) nums1[n1 + end - count] + nums1[n1 + end - count + 1]) / 2;
            }
        }
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        int count = 0;
        int end;
        Stack<Integer> stack = new Stack<>();
        boolean odd = ((nums1.length + nums2.length) & 1) == 1;


        end = (nums1.length + nums2.length) / 2 + 1;

        while (count < end) {
            count++;
            if (n1 < nums1.length && n2 < nums2.length) {

                stack.add(Math.min(nums1[n1], nums2[n2]));
                if (nums1[n1] <= nums2[n2]) {
                    n1++;

                } else {
                    n2++;
                }
            } else if (n1 == nums1.length) {
                stack.add(nums2[n2++]);
            } else {
                stack.add(nums1[n1++]);
            }
        }

        if (odd) {
            return stack.peek();
        } else {
            return ((double) stack.pop() +stack.pop())/2 ;
        }
    }
}
