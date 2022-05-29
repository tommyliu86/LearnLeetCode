package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-28 10:15
 */
public class RemoveOuterParentheses {
    class Solution {
        public String removeOuterParentheses(String s) {
            int left=0;
            int right=0;
            int count=0;
            StringBuilder builder = new StringBuilder();

            while (right<s.length()){
                if (s.charAt(right)=='('){
                    count++;
                }else{
                    count--;
                }
                right++;

                if (count==0){
                    builder.append(s.substring(left+1,right-1))    ;
                    left=right;
                }
            }
            return builder.toString();
        }
    }
}
