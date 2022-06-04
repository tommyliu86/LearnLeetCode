package com.lwf.learn.everyday.data.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 18:08
 */
public class Multiply {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            List<Integer> list = new ArrayList<>();
            char[] chars1 = num1.toCharArray();
            char[] chars2 = num2.toCharArray();
            for (int i = chars1.length - 1; i >= 0; i--) {
                int i1 = chars1[i] - '0';
                int j = chars1.length - 1 - i;
                int step = 0;
                for (int i2 = chars2.length - 1; i2 >= 0; i2--) {
                    int i3 = chars2[i2] - '0';
                    int cur = i1 * i3 + step;
                    step = cur / 10;
                    if (j > list.size() - 1) {
                        list.add(cur % 10);
                    } else {
                        step += (cur % 10 + list.get(j)) / 10;
                        cur = (cur % 10 + list.get(j)) % 10;
                        list.set(j, cur);
                    }
                    j++;
                }
                while (step != 0) {
                    if (j > list.size() - 1) {
                        list.add(step);
                        step = 0;
                    } else {
                        list.set(j, (list.get(j) + step) % 10);
                        step = (list.get(j) + step) / 10;
                        j++;
                    }
                }
            }
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
            }
            return builder.reverse().toString();
        }
    }
}
