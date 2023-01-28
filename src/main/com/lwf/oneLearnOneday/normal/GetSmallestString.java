package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/28 10:00
 */
public class GetSmallestString {
    /**
     * 贪心，从后向前，每次取最大的值，
     */
    class Solution {
        public String getSmallestString(int n, int k) {
            StringBuilder stringBuilder = new StringBuilder();
            int i=0;

            while (k-(n-i)>0){
                int sub = k - (n-i - 1);

                if (sub/26>0) {
                    k-=26;
                    stringBuilder.append('z');
                }else{
                    k-=sub;
                    stringBuilder.append((char)( 'a'+sub-1));
                }
                i++;
            }
            for (int j = 0; j <n- i; j++) {
                stringBuilder.append('a');
            }
            return stringBuilder.reverse().toString();
        }
    }
}
