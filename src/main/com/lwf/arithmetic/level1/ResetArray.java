package com.lwf.arithmetic.level1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 16:02
 */
public class ResetArray {
    class Solution {
        int[] origin;
        Random random;
        public Solution(int[] nums) {
            origin=nums;
            random=new Random();
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            int[] rtn=new int[origin.length];
            List<Integer> indexs=new LinkedList<>();
            for (int i = 0; i < origin.length; i++) {
                indexs.add(i);
            }
            for (int i = 0; i < rtn.length; i++) {
                int nextInt = random.nextInt(indexs.size());
                int ori = indexs.get(nextInt);
                indexs.remove(ori);
                rtn[i]=origin[ori];
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
