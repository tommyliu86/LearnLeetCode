package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 09:31
 */
public class OneEditAway {
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs( first.length()-second.length())>1){
                return false;
            }
            int fi=0;
            int si=0;
            int diff=0;
            while (fi<first.length()&&si<second.length()){
                if (first.charAt(fi)==second.charAt(si)){
                    fi++;
                    si++;
                }else{
                    diff++;
                    if (diff>1){
                        return false;
                    }
                    if (first.length()==second.length()){
                        fi++;
                        si++;
                    }else if (first.length()>second.length()){
                        fi++;
                    }else{
                        si++;
                    }
                }
            }
            return diff<2;
        }
    }
}
