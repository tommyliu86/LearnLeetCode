package com.lwf.learn.everyday.coding.level2.d2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 18:33
 */
public class Multiply {
    public class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0")||num2.equals("0")){
                return "0";
            }
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            List<Integer> list=new ArrayList<>();

            for (int i = chars1.length - 1; i >= 0; i--) {
                int m=chars1[i]-'0';
                int j=chars1.length - 1-i;
                int step=0;
                for (int k = chars2.length - 1; k >= 0; k--) {
                    int s=m*(chars2[k]-'0')+step;
                    step=s%10;
                    s=s/10;

                    int newi =j+ chars2.length-1-k;
                    if (list.size()>newi) {
                        Integer li = list.get(newi);
                        li=(li+s);
                        step+=li/10;
                        list.set(newi,li%10);
                    }else{
                        list.add(s);
                    }
                }
                if (step!=0){
                    list.add(step);
                }
            }
            Collections.reverse(list);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
            }
            return builder.toString();
        }
    }
}
