package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/11/25 9:04
 */
public class ExpressiveWords {
    public static void main(String[] args) {
        of();
    }
    private static void of(String... strings){
        for (String string : strings) {
            System.out.println(string);
        }
    }
    class Solution {
        public int expressiveWords(String s, String[] words) {
            List<Character> ns=new ArrayList<>();
            List<Integer> counts=new ArrayList<>();
            int i = 0;
            while (i <s.length()) {
                ns.add(s.charAt(i));
                int j = i +1;
                while (j <s.length() && s.charAt(j) == s.charAt(i)) {
                    j++;
                }
                counts.add(j-i);
                i=j;
            }
            int ans=0;
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (word.length()<ns.size()){
                    continue;
                }
                int k=0;
                int cur=0;

                while (k<word.length()){
                    if (word.charAt(k)==ns.get(cur)) {
                        int next=k+1;
                        while (next<word.length()&&word.charAt(next)==word.charAt(k)){
                            next++;
                        }
                        int length = next - k;
                        Integer count = counts.get(cur);
                        if (length==count||(length<count&&count>=3)){
                            k=next;
                            cur++;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
                if (k==word.length()){
                    ans++;
                }
            }
            return ans;
        }
    }
}
