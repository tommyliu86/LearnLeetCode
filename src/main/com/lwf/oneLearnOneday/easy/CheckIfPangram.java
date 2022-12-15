package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/12/13 9:31
 */
public class CheckIfPangram {
    class Solution {
        public boolean checkIfPangram(String sentence) {
            int count=0;
            int[] chars=new int[26];
            for (int i = 0; i < sentence.length(); i++) {
                int i1 = sentence.charAt(i) - 'a';
                chars[i1]++;
                if (chars[i1]==1){
                    count++;
                }
            }
            return count==26;
        }
    }
}
