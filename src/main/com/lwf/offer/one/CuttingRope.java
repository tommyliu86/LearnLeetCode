package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/7 15:17
 */
public class CuttingRope {
    /**
     * 贪心思路，让每一个位都最大化，因此从分为2个开始，每次都进行等分，余数添加到每个因子上，让因子变大
     */
    class Solution {
        public int cuttingRope(int n) {
            int max=0;
            int i=2;
            while (i<=n){
                int j=n/i;
                int k=n%i;
                int c=(int) Math.pow(j+1,k)*(int) Math.pow(j,i-k);
                if (max>c){
                    return max;
                }
                max=c;
                i++;
            }
            return max;
        }
    }
}
