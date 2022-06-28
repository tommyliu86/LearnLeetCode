package com.lwf.learn.everyday.arith.first.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-23 15:55
 */
public class LetterCasePermutation {
    class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> rtn=new ArrayList<>();
            char[] chars = s.toCharArray();
            recursive(chars,0,rtn);
            return rtn;
        }
        public void recursive(char[] chars,int i,List<String> rtn){
            if (i==chars.length){
                rtn.add(String.valueOf(chars));
                return;
            }
            recursive(chars,i+1,rtn);
            if ((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z')){
                if ((chars[i]>='a'&&chars[i]<='z')){
                    chars[i]=(char)(chars[i]-'a'+'A');
                }else{
                    chars[i]=(char)(chars[i]+'a'-'A');
                }
                recursive(chars,i+1,rtn);
            }

        }
    }
}
