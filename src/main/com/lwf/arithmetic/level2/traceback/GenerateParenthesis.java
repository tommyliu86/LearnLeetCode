package com.lwf.arithmetic.level2.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-01 16:41
 */
public class GenerateParenthesis {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> rtn=new ArrayList<>();
            recursive(n,n,new char[2*n],0,rtn);
            return rtn;
        }

        public void recursive(int left, int right, char[] chars, int index, List<String> list) {
            if (left > right) {
                return;
            }
            if (index == chars.length) {
                list.add(String.valueOf(chars));
                return;
            }
            if (left>0){

                chars[index] = '(';
                recursive(left - 1, right, chars, index + 1, list);
            }
            if (right>0){

                chars[index] = ')';
                recursive(left, right - 1, chars, index + 1, list);
            }
        }
    }
}
