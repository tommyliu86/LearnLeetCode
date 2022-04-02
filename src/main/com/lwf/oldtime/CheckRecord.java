package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-22-23:02
 * {@link 551.md}
 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        int CountA=0;
        int pre=0;
        int i=0;
        char[] chars=s.toCharArray();
        for (; i <s.length() ; i++) {
            if (chars[i]=='A'){

                if (++CountA>1){
                    return false;
                }
                pre=i;
            }else{
                if (chars[i]=='L'){
                    if (i-pre>2){
                        return false;
                    }
                }else{
                    pre=i;
                }
            }

        }
        return true;
    }
}
