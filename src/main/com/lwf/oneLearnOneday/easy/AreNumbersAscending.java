package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/1/3 9:27
 */
public class AreNumbersAscending {
    class Solution {
        public boolean areNumbersAscending(String s) {
                boolean ans=true;
                int pre=0;
            for (int i = 0; ans&& i < s.length(); i++) {
                if (s.charAt(i)>='1'&&s.charAt(i)<='9'){
                    int j=i+1;
                    int p=s.charAt(i)-'0';
                    while (j<s.length()&& s.charAt(j)!=' '){
                        p*=10;
                        p+=s.charAt(j)-'0';
                        j++;
                    }
                    if (pre>=p){
                        ans=false;
                    }
                    pre=p;
                    i=j;
                }
            }
            return ans;
        }
    }
}
