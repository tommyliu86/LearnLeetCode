package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/4/12 9:05
 */
public class LongestDecomposition {
    /**
     * 必须要考虑到贪心思路才行，前后缀相同时，取最小长度是最优解法。
     */
    class Solution {
        public int longestDecomposition(String text) {
            int ans=0;
            int l=0,r=text.length()-1;
            int k=0;
            while (l+k<r-k){
                if (!isOk(text,l,r-k,k)){
                    k++;
                }else{
                    ans+=2;
                    l+=k+1;
                    r-=k+1;
                    k=0;
                }
            }
            ans+=(l<=r)?1:0;
            return ans;
        }
        public boolean isOk(String text,int l1,int r1,int l){

            for (int i = 0; i <= l; i++) {
                if (text.charAt(l1+i)!=text.charAt(r1+i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
