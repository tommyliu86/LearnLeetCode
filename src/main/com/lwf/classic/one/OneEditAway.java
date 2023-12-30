package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/16 17:26
 */
public class OneEditAway {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs( first.length()-second.length())>1)return false;
            int i=0,j=0;
            int countf=0;
            int counts=0;
            while (i<first.length()&&j<second.length()){
                if (first.charAt(i)==second.charAt(j)) {
                    i++;
                    j++;
                }else{
                    if (first.length()==second.length()){
                        countf++;
                        counts++;
                        i++;
                        j++;
                    }else{
                        countf+=first.length()>second.length()?1:0;

                        counts+=first.length()>second.length()?0:1;

                        if (countf>0){
                            i++;
                        }else{
                            j++;
                        }
                    }

                    if (countf>1||counts>1){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
