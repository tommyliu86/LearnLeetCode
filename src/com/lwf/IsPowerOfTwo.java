package com.lwf;

/**
 * author Administrator
 * time 2019-07-26
 */
public class IsPowerOfTwo {
    /**
     * 2的n次方是1后n个0的二进制。因此直接使用n&n-1是否为0进行判断即可,但是对于该题，必须考虑n=0时的边界条件
     * 因为n&任何数==0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        if (n==1)return true;
        return (n&(n-1))==0;
    }
}
