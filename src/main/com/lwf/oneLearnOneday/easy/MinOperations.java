package com.lwf.oneLearnOneday.easy;

public class MinOperations {
    /**
     * 直接模拟
     */
    class Solution {
        public int minOperations(String s) {
            char[] chars = s.toCharArray();
            int first1=0;
            int first0=0;
            for (int i = 0; i < chars.length; i++) {
                if (i%2==0){
                    if (chars[i]=='1') {
                        first0++;
                    }else{
                        first1++;
                    }
                }else{
                    if (chars[i]=='1') {
                        first1++;
                    }else{
                        first0++;
                    }
                }
            }
            return Math.min(first0,first1);
        }
    }
    class Solution1 {
        public int minOperations(String[] logs) {
            return dfs(logs,0,0);
        }
        public int dfs(String[] logs,int index,int depth){
            if (index>=logs.length){
                return depth;
            }
            String log = logs[index];
            if ("../".equals(log)){
                return dfs(logs,index+1,depth==0?0:depth-1);
            }else if ("./".equals(log)){
                return dfs(logs,index+1,depth);
            }else{
                return dfs(logs,index+1,depth+1);
            }
        }
    }
}
