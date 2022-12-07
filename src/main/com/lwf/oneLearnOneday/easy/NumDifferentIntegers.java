package com.lwf.oneLearnOneday.easy;

import java.io.Reader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/12/6 9:01
 */
public class NumDifferentIntegers {
    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) '1');
        System.out.println((int) '9');
        new Solution().numDifferentIntegers("a123bc34d8ef34");
    }

    static
    class Solution {
        public int numDifferentIntegers(String word) {
            Set<String> ans=new HashSet<>();
            int l=0;

            while (l<word.length()){
                if (word.charAt(l)<'0'||word.charAt(l)>'9'){
                    l++;
                }else{
                    int start=l;
                    while (l<word.length()&& word.charAt(l)=='0'){
                        l++;
                    }
                    int end0=l;
                    while (l<word.length()&& word.charAt(l)>='0'&& word.charAt(l)<='9'){
                        l++;
                    }
                    int realS=start==end0?start:end0;
                    int realE=end0==l?end0:l;
                    if (realS== realE){
                        ans.add("0");
                    }else{
                        ans.add(word.substring(realS,realE));
                    }
                }
            }
            return ans.size();
        }
    }
    static
    class Solution1 {
        public int numDifferentIntegers(String word) {
            Set<String> ans = new HashSet<>();
            for (int i = 0; i < word.length(); ) {
                if (word.charAt(i) - '0' < 0 || word.charAt(i) - '0' > 9) {
                    i++;
                } else {
                    while (i < word.length() && word.charAt(i) == '0') {
                        i++;
                    }
                    if (i == word.length() || word.charAt(i) - '0' < 0 || word.charAt(i) - '0' > 9) {
                        ans.add("0");
                    } else {
                        int l = i++;
                        while (i < word.length() && word.charAt(i) - '0' >= 0 && word.charAt(i) - '0' <= 9) {
                            i++;
                        }
                        int r = i - 1;

                        ans.add(word.substring(l, r + 1));
                    }

                }
            }
            return ans.size();
        }
    }
}
