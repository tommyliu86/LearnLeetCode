package com.lwf.learn.everyday.first.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 11:37
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println('a'-0);
        System.out.println('A'-0);
    }
    class Solution {
        public List<String> letterCasePermutation(String s) {
            char[] chars = s.toCharArray();
            List<String> rtn=new ArrayList<>();
            recursive(chars,0,new char[chars.length],rtn);

            return rtn;

        }
        private void recursive(char[] chars,int index,char[] target,List<String> rtn){
            if (index==chars.length){
                rtn.add(new String(target));
                return;
            }
            char aChar = chars[index];
            if (aChar-0>='A'&&aChar-0<='z'){
                aChar=  aChar>'Z'?(char)(aChar-32):aChar;
                target[index]=aChar;
                recursive(chars,index+1,target,rtn);
                target[index]=(char) (aChar+32);
                recursive(chars,index+1,target,rtn);
            }else{
                target[index]=aChar;
                recursive(chars,index+1,target,rtn);
            }

        }
    }
}
