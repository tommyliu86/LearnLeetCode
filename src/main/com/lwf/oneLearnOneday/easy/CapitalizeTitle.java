package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/11/29 9:41
 */
public class CapitalizeTitle {
    class Solution {
        public String capitalizeTitle(String title) {
            StringBuilder stringBuilder = new StringBuilder();
            int i=0;
            while (i<title.length()){
                if (title.charAt(i)==' '){
                    stringBuilder.append(' ');
                    i++;
                }else{
                    int j=i+1;
                    while (j<title.length()&& title.charAt(j)!=' '){
                        j++;
                    }
                    if (j-i>2){
                        stringBuilder.append(Character.toUpperCase( title.charAt(i++)));

                    }
                    for (; i < j; i++) {
                        stringBuilder.append(Character.toLowerCase( title.charAt(i)));
                    }
                }
            }
            return stringBuilder.toString();
        }
    }
}
