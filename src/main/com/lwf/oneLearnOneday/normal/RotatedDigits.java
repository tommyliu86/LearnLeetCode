package com.lwf.oneLearnOneday.normal;

import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/9/25 17:58
 */
public class RotatedDigits {
    class Solution {

        public int rotatedDigits(int n) {
            int count =0;
            for (int i = 1; i <= n; i++) {
                boolean has=false;
                int k=i;
                while (k>0){
                    int j=k%10;
                    if (j==3||j==4||j==7){
                        has=false;
                        continue;
                    }
                    if (j==2||j==5||j==6||j==9){
                        has=true;
                    }
                    k/=10;
                }
                if (has){
                    count++;
                }
            }
            return count;
        }
    }
}
