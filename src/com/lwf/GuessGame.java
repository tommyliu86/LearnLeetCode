package com.lwf;

/**
 * author Administrator
 * time 2019-08-05
 */
public class GuessGame {
    public int guessNumber(int n) {
        int min=1;
        int max=n;
        int mid=min+(max-min)/2;
        while (min<max){
            if (guess(mid)>0){
                min=mid+1;
            }else if(guess(mid)<0){
                max=mid-1;
            }else{
                return mid;
            }
            mid=min+(max-min)/2;
        }
        return min;
    }
    int guess(int num){
        return 1;
    }
}

