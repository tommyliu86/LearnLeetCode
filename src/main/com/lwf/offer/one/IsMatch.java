package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/9 15:30
 */
public class IsMatch {
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] mark=new boolean[s.length()+1][p.length()+1];
            mark[0][0]=true;
            //从0开始
            for (int i = 0; i < mark.length; i++) {
                for (int j = 1; j < mark[i].length; j++) {
                    if (p.charAt(j-1)=='*'){
                        //第一种情况 j匹配0次
                        mark[i][j]=mark[i][j-2];
                        if (match(s,p,i,j-1)){
                            mark[i][j]=mark[i][j]||mark[i-1][j];
                        }
                    }else{
                        if (match(s,p,i,j)){
                            mark[i][j]=mark[i-1][j-1];
                        }
                    }
                }
            }
            return mark[s.length()][p.length()];
        }
        public boolean match(String s,String p,int i,int j){
            if(i==0) return false;
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
}
