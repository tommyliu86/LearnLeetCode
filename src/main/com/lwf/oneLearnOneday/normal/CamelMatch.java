package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/4/14 9:05
 */
public class CamelMatch {
    /**
     * 双指针比较即可，模拟
     */
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ans=new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                ans.add(check(queries[i],pattern));
            }
            return ans;
        }
        public boolean check(String query,String pattern){
            if (query.length()<pattern.length())return false;
            int i=query.length(),j=pattern.length(),i1=0,j1=0;
            while (j1<j){
                while (i1<i&&query.charAt(i1)!=pattern.charAt(j1)){
                    if (Character.isUpperCase(query.charAt(i1))){
                        return false;
                    }
                    i1++;
                }
                if (i1==i){
                    return false;
                }
                i1++;
                j1++;
            }
            while (i1<i){
                if (Character.isUpperCase(query.charAt(i1))) return false;
                i1++;
            }
            return true;
        }
    }
}
