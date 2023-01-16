package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/16 9:45
 */
public class AreSentencesSimilar {
    /**
     * 双指针，模拟，从左和右边去找
     * 简单思路的模拟，不需要想太复杂
     */
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            if (s1.length<s2.length){
                String[] temp=s1;
                s1=s2;
                s2=temp;
            }
            int l=0,r=0;
            while (l<s2.length&&s1[l].equals(s2[l])){
                l++;
            }
            while ( r<s2.length-l&&s1[s1.length-1- r].equals(s2[s2.length-1-r])){
                r++;
            }
            return s2.length==l+r;
        }
    }
    /**
     * 双指针，在多的一组中查找到不同的部分，不可行。
     */
    class Solution1 {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            if (sentence1.length()==sentence2.length()){
                return sentence1.equals(sentence2);
            }
            String[] s1 = sentence1.split(" ");
            String[] s2 = sentence2.split(" ");
            if (s1.length<s2.length){
                String[] temp=s1;
                s1=s2;
                s2=temp;
            }
            int gap=0,i=0;
            while (i-gap<s2.length){
                if (gap==0){
                    if (s1[i].equals(s2[i])){
                        i++;
                    }else{
                        int j=i;
                        while (i<s1.length&& !s1[i].equals(s2[j])){
                            i++;
                        }
                        gap=i-j;
                        i++;
                    }
                }else{
                    if (s1[i].equals(s2[i-gap])){
                        i++;
                    }else{
                        return false;
                    }
                }
            }
            return i==s1.length||gap==0;
        }
    }
}
