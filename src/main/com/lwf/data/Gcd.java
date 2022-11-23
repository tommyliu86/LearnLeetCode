package com.lwf.data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 14:44
 */
public class Gcd {
    //公约数 x>y ,使用辗转除余法，x%y是除去y之后剩余的比y小的一个数，x=y*n+x%y, x和y的最大公约数需要满足同时可以被x和y整除，因此也必须能被 x%y整除
    //,因此一直交换x%y,找到 x%y==0时的y值，就是最大公约数！！
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /**
     * 求最小公倍数，需要计算最大公约数，通过 两个的乘积 /最大公约数计算，
     * @param x
     * @param y
     * @return
     */
    public int lcm(int x,int y){
        return x*y/gcd(x,y);
    }
}
