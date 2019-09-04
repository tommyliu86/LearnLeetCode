package com.lwf;

/**
 * author Administrator
 * time 2019-09-04-22:43
 * {@link 5.md}
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if (s.length()<2) return s;
        int maxlength=0;
        int min=0;
        char[] chars=s.toCharArray();
        String rtn="";
        while (min<chars.length-maxlength){

            for (int i = min+maxlength; i <chars.length; i++) {
                if (isPa(chars,min,i)&&maxlength<(i-min+1)){
                    maxlength=i-min+1;
                    rtn=String.valueOf(chars,min,maxlength);
                }
            }
            min++;
        }
        return maxlength==0?String.valueOf(s.charAt(0)):rtn;
    }
    boolean isPa(char[] chars,int left,int right){

        while (left<right){
            if (chars[left++]!=chars[right--]){
                return false;
            }
        }
        return true;
    }
}
