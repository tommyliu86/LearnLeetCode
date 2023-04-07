package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/6 19:48
 */
public class MinWindow {
    /**
     * 滑动窗口，使用数组进行统计查询来标识
     */
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length()<t.length())return "";
            int[] chars=new int[26*2];
            for (int i = 0; i < t.length(); i++) {
                if (Character.isLowerCase( t.charAt(i))) {
                    chars[t.charAt(i)-'a']--;
                }else{
                    chars[t.charAt(i)-'A'+26]--;
                }
            }
            int i=0,j=0;
            int l=Integer.MAX_VALUE;
            int[] index=new int[2];
            while (j<s.length()){
                if (Character.isLowerCase( s.charAt(j))) {
                    chars[s.charAt(j)-'a']++;
                }else{
                    chars[s.charAt(j)-'A'+26]++;
                }
                if (isOk(chars)){
                    while (isOk(chars)){
                        if (Character.isLowerCase( s.charAt(i))) {
                            chars[s.charAt(i)-'a']--;
                        }else{
                            chars[s.charAt(i)-'A'+26]--;
                        }
                        i++;
                    }
                    if (l>j-i+1){
                        l=j-i+1;
                        index=new int[]{i-1,j};
                    }
                }
                j++;
            }
            if (l==Integer.MAX_VALUE)return "";
            return s.substring(index[0],index[1]+1);
        }
        public boolean isOk(int[] chars){
            boolean ok=true;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]<0){
                    ok=false;
                    break;
                }
            }
            return ok;
        }
    }
}
