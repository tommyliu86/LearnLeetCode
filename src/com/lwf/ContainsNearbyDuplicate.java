package com.lwf;


import java.util.*;

public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    /**
     * 思路，使用队列保存一个k长度的队列，并且滑动比较
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k >= nums.length) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 1; i++) {
                if ((nums[i] ^ nums[i + 1]) == 0) return true;
            }
            return false;
        } else {
            Set<Integer> queue = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (queue.size() > k) {
                    queue.remove(nums[i-k-1]);
                }
                if (queue.contains(nums[i])) {
                    return true;
                } else {
                    queue.add(nums[i]);
                }
            }
            return false;
        }
    }
}
