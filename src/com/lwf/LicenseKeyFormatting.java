package com.lwf;

/**
 * author Administrator
 * time 2019-08-18-22:50
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        int diff='a'-'A';
        int c=0;
        StringBuilder sBuilder=new StringBuilder();
        for (int i = S.length()-1; i >=0; i--) {
            char s=S.charAt(i);
            if (s=='-'){
                continue;
            }else {
                if (s>='a'&&s<='z') s=(char) (s-diff);
                if (c<K){
                    sBuilder.append(s);
                }else {
                    sBuilder.append('-').append(s);
                    c=0;
                }
                c++;
            }

        }
        return sBuilder.reverse().toString();
    }
}
