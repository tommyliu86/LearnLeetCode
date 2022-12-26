package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/12/25 12:24
 */
public class LargestMerge {
    class Solution {
        public String largestMerge(String word1, String word2) {
            int i1=0,i2=0;
            StringBuilder stringBuilder = new StringBuilder();
            while (i1<word1.length()||i2<word2.length()){
                if (i1<word1.length()&&word1.substring(i1).compareTo(word2.substring(i2))>0){
                    stringBuilder.append(word1.charAt(i1++));
                }else{
                    stringBuilder.append(word2.charAt(i2++));
                }
            }
            return stringBuilder.toString();
        }

    }

    /**
     * 需要考虑后缀和更大的先取，
     */
    class Solution1 {
        public String largestMerge(String word1, String word2) {
            StringBuilder stringBuilder = new StringBuilder();
            int i1 = word1.length() - 1;
            int i2 = word2.length() - 1;
            while (i1 >= 0 && i2 >= 0) {
                if (word1.charAt(i1) >= word2.charAt(i2)) {
                    stringBuilder.append(word2.charAt(i2--));
                } else {
                    stringBuilder.append(word1.charAt(i1--));
                }
            }
            while (i1 >= 0) {
                stringBuilder.append(word1.charAt(i1--));
            }
            while (i2 >= 0) {
                stringBuilder.append(word2.charAt(i2--));
            }
            return stringBuilder.reverse().toString();
        }
    }
}
