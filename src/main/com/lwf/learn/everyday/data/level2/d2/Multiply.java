package com.lwf.learn.everyday.data.level2.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 16:26
 */
public class Multiply {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0")||num2.equals("0")){
                return "0";
            }
            List<Integer> list=new ArrayList<>();

            char[] char1 = num1.toCharArray();
            char[] char2 = num2.toCharArray();
            for (int i = char1.length-1; i >=0; i--) {
                int j = char1[i] - '0';
                int step=0;
                int i1=char2.length-1;
                while (i1>=0){
                    int multi=(j*( char2[i1--]-'0'))+step;
                    step=multi/10;
                    multi%=10;

                    int index=char1.length-1-i+char2.length-1-i1;
                    if (index<list.size()){
                        Integer org = list.get(index);
                        org=org+multi;
                        step=step+ (org/10);
                        org%=10;
                        list.set(index,org);
                    }else{
                        list.add(multi);
                    }
                }
                if (step!=0){
                    list.add(step);
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                builder.append(list.get(i));
            }
            return builder.toString();
        }
    }
}
