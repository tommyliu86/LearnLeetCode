package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/2/23 11:35
 */
public class GuessGame {

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l=0,r=n;
            while(l<=r){
               int m= l+(r-l)/2;
                if (guess(m)==0) {
                    return m;
                }else if (guess(m)==1){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            return 0;
        }
    }

    int guess(int num){
        return 0;
    }
}
