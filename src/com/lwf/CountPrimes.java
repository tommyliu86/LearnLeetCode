package com.lwf;

public class CountPrimes {
    public int countPrimes(int n){
        if (n<3) return 0;
        int rtn=1;
        for (int i = 3; i <n ; i++) {
            if (i%2==0) continue;
            boolean is=true;
            /**
             * 此处的平方根方法需要思考一下
             */
            for (int j = 3; j <Math.sqrt(i) ; j+=2) {
                if(i%j==0){
                    is=false;
                    break;
                }
            }
            if(is) rtn++;
        }
        return rtn;
    }
}
