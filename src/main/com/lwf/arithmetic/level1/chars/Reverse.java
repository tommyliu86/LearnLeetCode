package com.lwf.arithmetic.level1.chars;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 19:43
 */
public class Reverse {
    public static void main(String[] args) {
        new Solution().reverse(123);
    }
   static class Solution {
        public int reverse(int x) {
            String s = String.valueOf(x);
            char[] chars = s.toCharArray();
            boolean minus=false;
            if (chars[0]=='-'){
                minus=true;
            }
            int rtn=0;
            if (minus){

                for (int i = chars.length-1; i > 1; i--) {
                    rtn=(rtn*10)+(chars[i]-'0');
                }
                if (rtn>(Integer.MAX_VALUE/10)){
                    return 0;
                }
                rtn=(rtn*10)+(chars[1]-'0');
            }else{
                for (int i = chars.length-1; i > 0; i--) {
                    rtn=(rtn*10)+(chars[i]-'0');
                }
                if (rtn>(Integer.MAX_VALUE/10)){
                    return 0;
                }
                rtn=(rtn*10)+(chars[0]-'0');
            }
            if (minus){
                return rtn*-1;
            }else{
                return rtn;
            }

        }
    }
}
