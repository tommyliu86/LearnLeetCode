package com.lwf.learn.everyday.coding.level2.d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-19 16:16
 */
public class AddToArrayForm {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> rtn=new ArrayList<>();
            int i=num.length-1;
            int step=0;
            while (i>=0||k>0||step!=0){
                int i1 = (i >= 0 ? num[i] : 0) + k % 10 + step;
                rtn.add( i1%10);
               k=k/10;
               step=i1/10;
               i--;
            }
            Collections.reverse(rtn);
            return rtn;
        }
    }
}
