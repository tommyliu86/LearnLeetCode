package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-07-22
 */

/**
 * 因子分解。10=2*5.
 * n！=(k*2)*(l*5) *other。2比5出现的多,因此，找到n！中出现了多少个5.
 * n/5 =出现了多少次5. 余数>=5则需要继续/5进行计算。如
 * 125=5*25  ，余下25,25个里面又有5个是5的倍数=5*5  ，则继续迭代
 * 求一个数是另外一个数的幂，可以使用辗转除余进行迭代。
 * 如 125 -5 则除5三次后余数<5,表示125是5的3次方到4次方之间。
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
       int rtn=0;
        while (n>=5){
            rtn+=n/5;
            n/=5;
        }
        return rtn;
    }
}
