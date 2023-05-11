package com.lwf.oneLearnOneday.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/5/11 9:22
 */
public class QueryString {
    /**
     * 滑动窗口+set+遍历
     */
    class Solution {
        public boolean queryString(String s, int n) {
            if (!s.contains("1")) return false;
            int l=2;
            Set<Integer> sets=new HashSet<>();

            int max=Math.min((1<<l)-1,n);
            int min=1<<(l-1);
            while (min<=n){
                int count=max-min+1;
                int i=0;
                while (count>0&& i+l<=s.length()){
                    if (s.charAt(i)=='1'){
                        int i1 = get(s, i, i + l);
                        if (!sets.contains(i1)&& i1>=min&&i1<=max) {
                            sets.add(i1);
                            count--;
                        }
                    }
                    i++;
                }
                if (count>0){
                    return false;
                }
                l++;
                 max=Math.min((1<<l)-1,n);
                 min=1<<(l-1);
            }
            return true;
        }
        private int get(String s,int start,int end){
            int i=0;
            for (int i1 = 0; i1+start < end; i1++) {
                char c = s.charAt(end - i1 - 1);
                if (c=='1'){
                    i|=1<<i1;
                }
            }
            return i;

        }

    }
}
