package com.lwf.arithmetic.level1.chars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 20:23
 */
public class CountAndSay {
    public static void main(String[] args) {
        char[] chars=new char[10];
        chars[0]='a';
        System.out.println(String.valueOf(chars));
    }
    /**
     * 第二版，使用递归代替递推。递推是从前向后，动态规划的方式，
     * 递归则是利用方法调用来省去栈的方法，是先总结状态转移方程，然后从n ->n-1...->1的方式来解决
     * 往往直觉上用递推的解法，换用递归会很简单！
     * 而直觉上用递归的方法，换用递推会很快速！
     */
    class num2 {
        public String countAndSay(int n) {
            if (n == 1) {
                return String.valueOf(1);
            }

            String s = countAndSay(n - 1);

            char[] newList =new char[s.length()*2];
            int index=0;
            char cursor = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == cursor) {
                    count++;
                } else {
                    newList[index++]=(char) (count+'0');
                    newList[index++]=(cursor);
                    count = 1;
                    cursor = s.charAt(j);
                }
            }
            newList[index++]=(char)(count+'0');
            newList[index]=(cursor);

            return String.valueOf(newList).trim();
        }
    }

    /**
     * 第一版，使用List来保存中间的每一次的结果，最后会多出一次size的遍历
     */
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return String.valueOf(1);
            }

            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int i = 2; i <= n; i++) {
                List<Integer> newList = new ArrayList<>();
                Integer cursor = next.get(0);
                int count = 1;
                for (int j = 1; j < next.size(); j++) {
                    if (next.get(j) == cursor) {
                        count++;
                    } else {
                        newList.add(count);
                        newList.add(cursor);
                        count = 1;
                        cursor = next.get(j);
                    }
                }
                newList.add(count);
                newList.add(cursor);
                next = newList;
            }
            StringBuilder rtn = new StringBuilder();
            for (int i = 0; i < next.size(); i++) {
                rtn.append(next.get(i));
            }
            return rtn.toString();
        }
    }
}
