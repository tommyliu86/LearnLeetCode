package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/6/6 8:57
 */
public class EqualPairs {

    class Solution {
        public int equalPairs(int[][] grid) {
        //记录行字符串和出现次数的map
            Map<String,Integer> rows=new HashMap<>();
            //遍历grid的每一行,构建行字符串,并记录在map中,出现次数+1
            for (int i = 0; i < grid.length; i++) {
                String str = buildRow(grid[i]);
                rows.put(str,rows.getOrDefault(str,0)+1);
            }
            //结果初始化为0
            int ans=0;

            //遍历grid的每一列,构建列字符串
            for (int i = 0; i < grid.length; i++) {
                String str = buildCol(grid, i);

                //在map中查找该列字符串,并将出现次数加到结果中
                ans+=rows.getOrDefault(str,0);
            }
            return ans;
        }

        //构建行字符串的方法
        public String buildRow(int[] ints){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                stringBuilder.append(ints[i]).append(",");
            }
            return stringBuilder.toString();
        }

        //构建列字符串的方法
        public String buildCol(int[][] ints,int col){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ints.length; i++) {
                stringBuilder.append(ints[i][col]).append(",");
            }
            return stringBuilder.toString();
        }
    }
}
