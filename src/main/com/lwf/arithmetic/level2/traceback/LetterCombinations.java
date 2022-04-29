package com.lwf.arithmetic.level2.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-27 18:42
 */
public class LetterCombinations {
    public static void main(String[] args) {
        char[][] maps=new char[][]{{'1'},{'1','2'}};
        for (char[] map : maps) {
            System.out.println("map.length:"+map.length);
            for (int i = 0; i < map.length; i++) {
                System.out.println(map[i]);

            }
        }
    }

    static class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> rtn=new ArrayList<>();
            if (digits.length()==0){
                return rtn;
            }
            char[][] maps = new char[][]{
                    {'a','b','c'},
                    {'d','e','f'},
                    {'g','h','i'},
                    {'j','k','l'},
                    {'m','n','o'},
                    {'p','q','r','s'},
                    {'t','u','v'},
                    {'w','x','y','z'}
            };

            char[] chars = digits.toCharArray();
            recursive(chars,0,new char[chars.length],rtn,maps);
            return rtn;
        }
        public  void recursive(char[] chars,int i,char[] chose, List<String> rtn,char[][] maps){
            if (i==chars.length){
                rtn.add(String.valueOf(chose));
                return;
            }
            char aChar = chars[i];
            int j = aChar - '2';
            for (int k = 0; k < maps[j].length; k++) {
                chose[i]=maps[j][k];
                recursive(chars,i+1,chose,rtn,maps);
            }
        }
    }
}
