package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

public class NextGreaterElement {
    class Solution {
        public int nextGreaterElement(int n) {
                String strN = String.valueOf(n);
                char[] chars = strN.toCharArray();
                int i=chars.length-1;
                while (i>=0&&chars[i-1]>=chars[i]) {
                    i--;
                }
                if (i<0) {
                    return -1;
                }
                int j=i+1;
                while (j<chars.length&&chars[j]>chars[i]) {
                    j++;
                }
                j--;
                char temp=chars[i];
                chars[i]=chars[j];
                chars[j]=temp;

                Arrays.sort(chars, i+1, chars.length);
                int r=0;
                for (int k = 0; k < chars.length; k++) {
                    if ((r*10>Integer.MAX_VALUE/10)||(r*10==Integer.MAX_VALUE/10&&chars[k]-'0'>Integer.MAX_VALUE%10)) {
                        return -1;
                    }
                    r=r*10+chars[k]-'0';
                }
                return r;
        }
    }
}
