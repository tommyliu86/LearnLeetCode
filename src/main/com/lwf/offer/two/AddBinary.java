package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/2/17 13:46
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] charsa = a.toCharArray();
            char[] charsb = b.toCharArray();
            int i=0,ia=charsa.length-1,ib=charsb.length-1;
            while (i!=0||ia>=0||ib>=0){
                int ja= ia<0?0: (charsa[ia--]-'0');
                int jb= ib<0?0: (charsb[ib--]-'0');
                int newi=i+ja+jb;
                stringBuilder.append(newi%2);
                i=newi/2;
            }
            return stringBuilder.reverse().toString();
        }
    }
}
