package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/2/13 9:39
 */
public class BalancedString {
    public static void main(String[] args) {
        new Solution().balancedString("QQQE");
    }
    static
    class Solution {
        /**
         * 滑动窗口，统计数据可以是窗口内，也可以是窗口外的！！！
         * @param s
         * @return
         */
        public int balancedString(String s) {
            int n = s.length();
            int[] marks=new int[4];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int cur=index(c);
                marks[cur]++;
            }

            if (isOk(marks,n/4)){
                return 0;
            }
            int i=0,j=0;
            int min=Integer.MAX_VALUE;
            while (j<s.length()){
                char c = s.charAt(j);
                int cur=index(c);
                marks[cur]--;
                j++;
                if (isOk(marks,n/4)){
                    while (i<j&& isOk(marks,n/4)){
                        marks[index(s.charAt(i++))]++;
                    }
                    min=Math.min(min,j-i+1);
                }

            }
            return min;

        }
        public int index(char c){
            return c=='Q'?0:c=='W'?1:c=='E'?2:3;
        }
        public boolean isOk(int[] marks,int n){
            for (int i = 0; i < marks.length; i++) {
                if (marks[i]>n){
                    return false;
                }
            }
            return true;
        }
    }
}
