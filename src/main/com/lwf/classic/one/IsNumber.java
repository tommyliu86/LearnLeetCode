package com.lwf.classic.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/2/8 16:03
 */
public class IsNumber {
    /**
     * 边界条件判断
     */
    class Solution {
        public boolean isNumber(String s) {
            nums.addAll(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
            if (s.length()==0)return false;
            char[] chars = s.toCharArray();
            int l=0,r=chars.length-1,m=-1;
            while (l<s.length()&& chars[l]==' ')l++;
            while (r>=0&& chars[r]==' ')r--;
            if (l>r) return false;
            if (chars[l]=='+'||chars[l]=='-')l++;

            m=s.indexOf('e');
            if (m==-1) m=s.indexOf('E');
            if (m==l||m==r){
                return false;
            }
            if (m==-1){
                if (s.indexOf('.')!=-1)return isFloat(chars,l,r);
                return isInteger(chars,l,r);
            }else{
                int lm=m;
                m++;
                if (chars[m]=='+'||chars[m]=='-') m++;
                return(isInteger(chars,l,lm-1)||isFloat(chars,l,lm-1))&&isInteger(chars,m,r);
            }
        }
        Set<Character> nums=new HashSet<>();
        public boolean isInteger(char[] chars,int l,int r){
            if (l>r)return false;
            for (int i = l; i <= r; i++) {
                if (!nums.contains(chars[i])){
                    return false;
                }
            }
            return true;
        }
        public boolean isFloat(char[] chars,int l,int r){
            int i=l;
            while (i<=r&&chars[i]!='.'){
                i++;
            }
           if (i==l){
               return isInteger(chars,i+1,r);
           }
           if (i==r){
               return isInteger(chars,l,i-1);
           }

            return isInteger(chars,l,i-1)&&isInteger(chars,i+1,r);
        }
    }
}
