package com.lwf.learn.everyday.arith.first.day11;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 10:16
 */
public class Combine {

    class Solution {
        /**
         * 递归解法，每个值 i 都有两种选择，用和不用。
         * @param n
         * @param k
         * @return
         */
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> rtn = new ArrayList<>();
            combine(n, 1, k, new LinkedList<Integer>(), rtn);
            return rtn;
        }

        private void combine(int n, int curr, int k, LinkedList<Integer> currList, List rtn) {
            if (curr > n||currList.size()==k) {
                if (currList.size() == k) {
                    rtn.add(new ArrayList(currList));
                }
                return;
            }
            combine(n, curr + 1, k, currList, rtn);
            currList.add(curr);
            combine(n, curr + 1, k, currList, rtn);
            currList.removeLast();
        }
    }
}
