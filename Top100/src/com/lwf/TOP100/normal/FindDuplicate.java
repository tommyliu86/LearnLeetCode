package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-11 Time: 10:07
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        int finder = nums[0];
        while (finder != tortoise) {
            finder = nums[finder];
            tortoise = nums[tortoise];
        }
        return finder;
    }
}
