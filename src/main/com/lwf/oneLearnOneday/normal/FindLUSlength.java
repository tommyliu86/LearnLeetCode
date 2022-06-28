package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-27 11:00
 */
public class FindLUSlength {
    public static void main(String[] args) {
        String[] a=new String[]{"a","aaa","aa"};
        Arrays.sort(a,Comparator.comparing(String::length));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs,Comparator.comparing(String::length));
            for (int i = strs.length - 1; i >= 0; i--) {
                String cur = strs[i];
                int j=strs.length-1;
                boolean unque=true;
                while (unque&& j>=0&&strs[j].length()>=cur.length()){
                    if (j!=i&& isSubStr(cur, strs[j])) {
                        unque=false;
                    }
                    j--;
                }
                if (unque){
                    return cur.length();
                }
            }


            return -1;
        }

        public boolean isSubStr(String a,String b){
            int ai=0;
            int bi=0;
            while (ai<a.length()&&bi<b.length()){
                if (a.charAt(ai)==b.charAt(bi)){
                    ai++;
                    bi++;
                }else{
                    bi++;
                }
            }
            return ai==a.length();
        }

    }
}
