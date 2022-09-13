package com.lwf.oneLearnOneday.easy;

public class MinOperations {
    class Solution {
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
