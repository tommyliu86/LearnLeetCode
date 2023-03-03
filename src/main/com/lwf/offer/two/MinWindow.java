package com.lwf.offer.two;

import com.lwf.oneLearnOneday.normal.PrintBin;

/**
 * @author liuwenfei
 * @date 2023/3/3 11:19
 */
public class MinWindow {
    public static void main(String[] args) {
        System.out.println('Z'-0);
        System.out.println('a'-0);
    }

    /**
     * 滑动窗口+计数器，同时使用计数器
     */
    class Solution {
        public String minWindow(String s, String t) {
            if (t.length()>s.length()) return "";
            int[] count=new int[26*2];
            int total=0;
            for (int i = 0; i < t.length(); i++) {
                int index = getIndex(t.charAt(i));
                if (count[index]==0) {
                    total++;
                }
                count[index]--;
            }
            int i=0,j=0;
            int l=s.length()+1,il=0,ij=0;
            while (j<s.length()){
                int index = getIndex(s.charAt(j++));
                count[index]++;
                if (count[index]==0){
                    total--;
                }
                if (total==0){
                    while (i<j&&total==0){
                        int index1 = getIndex(s.charAt(i++));
                        count[index1]--;
                        if (count[index1]==-1) total++;
                    }
                    if (l>(j-i+1)){
                        l=j-i+1;
                        il=i-1;
                        ij=j;
                    }
                }
            }
            return s.substring(il,ij);
        }
        public int getIndex(char a){
            int index;
            if (a>='a') {
                index=a-'a';
            }else{
                index=a-'A'+26;
            }
            return index;
        }
    }
}
