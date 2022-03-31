package com.lwf.TOP100.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * 728. 自除数
 * @author: liuwenfei14
 * @date: 2022-03-31 09:06
 */
public class SelfDividingNumbers {
    /**
     * 模拟计算，通过除余计算一个数是否自除数，遍历left>right
     */
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> rtn=new ArrayList<>();
            while (left<=right){
                if (checkNumber(left)) {
                    rtn.add(left);
                }
                left++;
            }

            return  rtn;
        }
        private boolean checkNumber(int n){
            if (n==0) {
                return false;
            }
            int single=1;
            int left=n;
            boolean rtn=true;
            while (rtn&& left!=0){
                single=left%10;
                left=left/10;
               rtn=single!=0&& ( n%single==0);
            }
            return rtn;
        }
    }
}
