package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/9/28 9:22
 */
public class GetKthMagicNumber {
    /**
     * 三指针直接dp就行
     */
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] ks=new int [k];
            ks[0]=1;
            int i3=0;
            int i5=0;
            int i7=0;
            for (int i = 1; i < ks.length; i++) {
                while (ks[i3]*3<ks[i-1]){
                    i3++;
                }
                int s3=ks[ i3]*3;
                while (ks[i5]*5<ks[i-1]){
                    i5++;
                }
                int s5=ks[ i5]*5;
                while (ks[i7]*7<ks[i-1]){
                    i7++;
                }
                int s7=ks[ i7]*7;
                ks[i]=Math.min(s3,Math.min(s5,s7));
                if (ks[i]==s3){
                    i3++;
                }
                if (ks[i]==s5){
                    i5++;
                }
                if (ks[i]==s7){
                    i7++;
                }
            }
            return ks[k-1];
        }
    }
}
