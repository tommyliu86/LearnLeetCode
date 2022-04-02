package com.lwf.oldtime;



/**
 * author Administrator
 * time 2019-07-22
 */
public class ConvertToTitle {
    public int titleToNumber(String s) {
        if(s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int rtn=0;
        for (int i = chars.length - 1; i >= 0; i--) {
            rtn+=(chars[i] +1-'A')*Math.pow (26,chars.length-1-i);

        }
        return rtn;
    }
    public String convertToTitle(int n) {
        StringBuilder builder=new StringBuilder();
        while (n!=0) {
            int sub=n%26;
            if (sub==0) {
                builder.append('A');
                n-=26;
            }else{
                builder.append((char)('A'-1+sub));
                n=n/26;
            }
        }
        return builder.reverse().toString();
    }
}
