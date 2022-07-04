package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DiffWaysToCompute {
    /**
     * 暴力递归，对计算符号左右的结果进行计算，然后进行笛卡尔积。
     */
    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> ints = new ArrayList<>();
            List<Character> calcs = new ArrayList<>();
            char[] chars = expression.toCharArray();
            int i = 0;
            while (i < chars.length) {
                int j = 0;
                while (i < chars.length && chars[i] != '+' && chars[i] != '-' && chars[i] != '*') {
                    j = j * 10 + chars[i++] - '0';
                }
                ints.add(j);
                if (i<chars.length) {
                    calcs.add(chars[i++]);
                }
            }
         return   diff(ints, calcs, 0, ints.size()-1);
        }
        public List<Integer> diff(List<Integer> ints,List<Character> calcs,int l,int r){
            if (l==r) {
                return Collections.singletonList(ints.get(l));
            }
            List<Integer> rtn=new ArrayList<>();
            for (int i = l; i < r; i++) {
                List<Integer> lefts=diff(ints, calcs, l, i);
                List<Integer> rights=diff(ints, calcs, i+1, r);
                Character calc=calcs.get(i);
                for (int j = 0; j < lefts.size(); j++) {
                    for (int j2 = 0; j2 < rights.size(); j2++) {
                        if (calc=='+') {
                            rtn.add(lefts.get(j)+rights.get(j2));
                        }else  if (calc=='-') {
                            rtn.add(lefts.get(j)-rights.get(j2));
                        }else{
                    
                                rtn.add(lefts.get(j)*rights.get(j2));
                        }
                    }
                }
                
            }
                return rtn;
        }
    }

        

}
