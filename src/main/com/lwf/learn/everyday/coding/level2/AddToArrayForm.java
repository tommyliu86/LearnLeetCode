package com.lwf.learn.everyday.coding.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 11:49
 */
public class AddToArrayForm {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> list=new ArrayList<>();
            int step=0;
            for (int i = num.length - 1; i >= 0; i--) {
                int sum = num[i] + k % 10+step;
                k/=10;
                list.add(sum%10);
                step=sum/10;
            }
            while (k!=0||step!=0){
                int sum= k%10+step;
                k/=10;
                list.add(sum%10);
                step=sum/10;
            }
            Collections.reverse(list);
            return list;
        }
    }
}
