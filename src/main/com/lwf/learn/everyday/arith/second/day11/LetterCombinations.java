package com.lwf.learn.everyday.arith.second.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-23 10:32
 */
public class LetterCombinations {
    class Solution {
        public List<String> letterCombinations(String digits) {

            char[] chars = digits.toCharArray();
            List<String> rtn=new ArrayList<>();
            char[] dynamic=new char[digits.length()];
            recursive(chars,dynamic,0,rtn);
            return rtn;
        }
        public void recursive(char[] chars,char[] dynamic,int index,List<String> rtn){
            if (index>=chars.length){
                if (dynamic.length>0) {

                    rtn.add( String.valueOf(dynamic));
                }
                return;
            }
            char aChar = chars[index];
            char[] chars1 = achars[aChar - '2'];
            for (int i = 0; i < chars1.length; i++) {
                dynamic[index]=chars1[i];
                recursive(chars,dynamic,index+1,rtn);
            }
        }
        char[][]  achars={
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'},
        };
    }
}
