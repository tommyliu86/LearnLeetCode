package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/10/3 19:24
 */
public class CheckOnesSegment {
    class Solution {
        public boolean checkOnesSegment(String s) {
            if (s.length()==0||"0"==s){
                return true;
            }
            char[] chars = s.toCharArray();
           int i=chars.length-1;
           boolean rtn=true;
           while (i>=0&&rtn){
               if (chars[i]!='1'){
                   i--;
               }else{
                   while (i>=0&& chars[i]=='1'){
                       i--;
                   }
                   if (i>=0){
                       rtn=false;
                   }
               }
           }
           return rtn;
        }
    }
}
