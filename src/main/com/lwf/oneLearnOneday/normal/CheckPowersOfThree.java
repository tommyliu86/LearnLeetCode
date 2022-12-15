package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/12/9 9:14
 */
public class CheckPowersOfThree {
    /**
     * 辗转除余法应用
     *
     */
    class Solution {
        public boolean checkPowersOfThree(int n) {
            if (n==0){
                return true;
            }
            int mod = n % 3;
            if (mod==0){
                return checkPowersOfThree(n/3);
            }else if (mod==1){
                return checkPowersOfThree((n-1)/3);
            }else{
                return false;
            }
        }
    }
}
