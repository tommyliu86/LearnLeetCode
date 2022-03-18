package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-12-11 Time: 10:07
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do { //快慢指针，最终指针如果重合，表示找到了 指向同一个index的两个数，
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
    public int findDuplicate1(int[] nums) {
        int indexT=0;
        int indexTpre=0;
        int tortoise = nums[indexT];
        int hare = nums[0];
        do { //快慢指针，最终指针如果重合，表示找到了 指向同一个index的两个数，
            indexTpre=indexT;
            indexT=tortoise;
            tortoise = nums[indexT];

            hare = nums[nums[hare]];
        } while (tortoise != hare);

        return nums[indexT]==indexT?nums[indexTpre]:nums[indexT];
    }
}
