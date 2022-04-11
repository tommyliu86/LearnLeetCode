package com.lwf.level1.chars;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-11 16:25
 */
public class MyAtoi {
    /**
     * 使用long型来兼容int的溢出。
     */
    class Solution {
        public int myAtoi(String s) {
            char[] chars = s.toCharArray();
            int cursor=0;
            int status=0;
            boolean flag=true;
            long rtn=0;

            while (status!=3&& cursor<s.length()){
                if (status==0){
                    if (chars[cursor]==' ') {
                        cursor++;
                    }else {
                        status=1;
                    }
                }else  if (status==1){
                    if (chars[cursor]=='+'||chars[cursor]=='-'){
                        if (chars[cursor]=='-'){
                            flag=false;
                        }
                        cursor++;
                    }
                    status=2;

                }else if (status==2){
                    if (chars[cursor]>='0'&&chars[cursor]<='9'){
                        if ((flag&&rtn>Integer.MAX_VALUE)||(!flag&&rtn>((long) Integer.MAX_VALUE+1))){

                            status=3;
                        }else{
                            rtn=rtn*10+(chars[cursor]-'0');
                            cursor++;
                        }
                    }else{
                        status=3;
                    }
                }

            }
            return  flag?(int) Math.min( rtn,Integer.MAX_VALUE) :(int) Math.max( -1*rtn,Integer.MIN_VALUE);
        }

    }
}
