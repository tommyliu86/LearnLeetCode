package com.lwf.oneLearnOneday.normal;

/**
 * author Administrator
 * time 2019-09-04-22:43
 * {@link 5.md}
 */
public class LongestPalindrome {
    public class  main1{
        /**
         * 暴力解法，设置开始位置left，然后遍历left-》length，找到相同char则判断当前是否是回文。
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s.length()<2) return s;
            int maxlength=0;
            int min=0;
            char[] chars=s.toCharArray();
            int left=0;
            int right=0;
            while (min<chars.length-maxlength){
                char currentChar = chars[min];
                for (int i = min+1; i < chars.length; i++) {
                    if (chars[i]==currentChar&&isPa(chars,min,i)){
                        if (i-min+1>maxlength){
                            left=min;
                            right=i;
                            maxlength=i-min+1;
                        }
                    }
                }

                min++;
            }
            return maxlength==0?String.valueOf(s.charAt(0)):s.substring(left,right);
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
