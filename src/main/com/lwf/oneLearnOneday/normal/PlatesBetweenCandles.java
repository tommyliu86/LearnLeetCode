package com.lwf.oneLearnOneday.normal;

import jdk.nashorn.internal.runtime.JSONFunctions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/plates-between-candles/
 * 2055. 蜡烛之间的盘子
 * @author: liuwenfei14
 * @date: 2022-03-08 11:22
 */
public class PlatesBetweenCandles {
    public static class plate{


        public static void main(String[] args) {

          String s=  "***|**|*****|**||**|*";
          int[][] qu=new int[2][2];

            qu[0]=new int[]{1,17};
            qu[1]=new int[]{5,14};

            new plate().platesBetweenCandles(s,qu);
        }

        /**
         * 模拟法，先遍历，找到每个位置左边和右边最近的蜡烛，同时，使用一个数组记录蜡烛出现总数，
         * 求解【left,right】= Max-left(right)- Min-right(left)-count(ax-left(right)- Min-right(left))
         * @param s
         * @param queries
         * @return
         */
        public  int[] platesBetweenCandles(String s, int[][] queries) {
            char[] chars = s.toCharArray();
            int[] left = new int [chars.length];
            int[] right = new int [chars.length];
            int[] counts=new int [chars.length];
            int leftIndex=-1;
            int count=0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='|') {
                    leftIndex=i;
                    count++;
                }

                counts[i]=count;
                left[i]= leftIndex==-1?-1:leftIndex;
            }
            int rightIndex=-1;
            for (int i = chars.length-1; i >=0 ; i--) {
                if (chars[i]=='|') {
                    rightIndex=i;

                }
                right[i]=rightIndex==-1?-1:rightIndex;

            }
            int[] rtn=new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int leftI = right[query[0]];
                int rightI = left[query[1]];
                rtn[i]=leftI==-1||rightI==-1||leftI>=rightI?0:(rightI-leftI-(counts[rightI]-counts[leftI]));
            }
            return rtn;
        }
        public  int[] platesBetweenCandles1(String s, int[][] queries) {
            char[] chars = s.toCharArray();
            int[] left = new int [chars.length];
            int[] right = new int [chars.length];
            int[] counts=new int [chars.length];
            int leftIndex=-1;
            int count=0;
            int rightIndex=-1;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='|') {
                    leftIndex=i;
                    count++;
                }
                if (chars[chars.length-1-i]=='|'){
                    rightIndex=chars.length-1-i;
                }
                right[chars.length-1-i]=rightIndex==-1?-1:rightIndex;
                counts[i]=count;
                left[i]= leftIndex==-1?-1:leftIndex;
            }

            int[] rtn=new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int leftI = right[query[0]];
                int rightI = left[query[1]];
                rtn[i]=leftI==-1||rightI==-1||leftI>=rightI?0:(rightI-leftI-(counts[rightI]-counts[leftI]));
            }
            return rtn;
        }
    }
    /**
     * 暴力解法，遍历+双指针，记录两个指针中间的最左最右蜡烛位置，并记录
     * @param s
     * @param queries
     * @return
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int[][] counts=new int[chars.length][chars.length];

        for (int i = 0; i < chars.length; i++) {
            int left=chars.length;
            int right=-1;
            int count=0;
            for (int j = i; j < chars.length; j++) {
                if (chars[j]=='|') {
                    if (left==chars.length){
                        left=j;
                    }
                    if(right!=-1){
                        count++;
                    }
                    right=j;
                }
                counts[i][j]= right>left? right-left-count:0;
            }
        }
        int[] rtn=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            rtn[i]=counts[query[0]][query[1]];
        }
        return rtn;
    }
}
