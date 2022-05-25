package com.lwf.learn.everyday.arith.second.day20;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-02 11:46
 */
public class Randoms {
    class Solution {

        public Solution(int[] nums) {
            this.origin=nums;
            random=new Random();
        }
        int[] origin;
        Random random;

        public int[] reset() {
        return origin;
        }

        public int[] shuffle() {
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < origin.length; i++) {
                list.add(origin[i]);
            }
            int[] rtn=new int[origin.length];
            for (int i = 0; i < rtn.length; i++) {
                int i1 = random.nextInt(origin.length - i);
               rtn[i]= list.get(i1);
               list.remove(i1);
            }
            return rtn;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
