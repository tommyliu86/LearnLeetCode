package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-12
 */
public class CountSegments {
    public int countSegments(String s) {
        if (s==null) return 0;
        s=s.trim();
        if (s.length()==0) return 0;
        char[] chars=s.toCharArray();
        int count=0;
        int start=-1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' '){
                start=i;
            }else{
                if (start==i-1){
                    count++;
                }
            }
        }
        return count==0?0:count+1;
    }
    public int countSegments1(String s) {
        if (s==null) return 0;
        s=s.trim();
        if (s.length()==0) return 0;

        int count=0;
        int start=-1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                start=i;
            }else{
                if (start==i-1){
                    count++;
                }
            }
        }
        return count+1;
    }
}
