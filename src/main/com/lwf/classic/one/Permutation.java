package com.lwf.classic.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/2/9 14:42
 */
public class Permutation {
    class Solution {
        public String[] permutation(String s) {
            char[] list =  s.toCharArray();
           int[] mark=new int[s.length()];
            char[] chars=new char[s.length()];
            Set<String> ans=new HashSet<>();
            recurse(chars,0,list,mark,ans);
            return ans.toArray(new String[s.length()]);
        }
        public void recurse(char[] chars,int i,char[] list,int[] mark, Set<String> ans){
            if (i==chars.length){
                ans.add(String.valueOf(chars));
                return;
            }
            for (int j = 0; j < list.length; j++) {
                if (mark[j]==0){
                    chars[i]=list[j];
                    mark[j]=1;
                    recurse(chars,i+1,list,mark,ans);
                    mark[j]=0;
                }
            }
        }
    }
}
