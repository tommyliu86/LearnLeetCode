package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-02-14 22:17
 * https://leetcode-cn.com/problems/counting-bits/
 * 338. 比特位计数
 */
public class CountBits {
    /**
     * for循环，直接暴力求解。使用位运算直接计算每个数字i的每一个位上的数字是1与否。位与& 位或| 位异或^
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] rtns=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            rtns[i]=countFor(i);
        }
        return rtns;
    }
    public int countFor(int i){
        int rtn=0;
        while (i!=0){
            rtn+=i&1;
            i=i>>1;
        }
        return rtn;
    }

    /**
     * 动态规划。考虑位运算的特殊性。i>>1比原来少了2倍或2倍+1，因此可以从该方向考虑 i中的1个数公式f（i）=f（i>>1）+1 ||f(i>>1),看i为奇数或偶数决定。
     * 因此使用动态规划，从前向后依次进行计算即可。使用数组int[n+1]保存小的计算个数即可
     * @param n
     * @return
     */
    public int[] countBits1(int n) {
        int[] rtns=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            if ((i&1)==1){
                rtns[i]=rtns[i>>1]+1;
            }else{
                rtns[i]=rtns[i>>1];
            }
        }
        return rtns;
    }

}
