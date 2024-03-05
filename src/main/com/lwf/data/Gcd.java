package com.lwf.data;

import java.util.ArrayList;
import java.util.List;

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
     * 递推解法比递归解法快 1倍左右。。
     * @param x
     * @param y
     * @return
     */
    public int gcd2(int x,int y){
        while (x!=0){
            int temp=y%x;
            y=x;
            x=temp;
        }
        return y;
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

    /**
     * 找小于n的所有的质数
     * @param n
     */
    public List<Integer> prime(int n){
        //false=质数，true=非质数
        boolean[] marks=new boolean[n+1];
        List<Integer> ans=new ArrayList<>();
        for (int i = 2; i < marks.length; i++) {
            if (!marks[i]){
                ans.add(i);
                //i 是质数，那么i 的倍数都是非质数 ，j+=i就是往后的倍数，
                // 同时，j开始位置从i*i开始，因为从2倍到i-i倍，这些数字在i之前已经出现过，那就肯定比遍历处理过了，不需要重复处理！
                for (int j = i*i; j < marks.length; j+=i) {
                    marks[j]=true;
                }
            }
        }
        return ans;
    }
}
