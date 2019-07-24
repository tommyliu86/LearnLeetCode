package com.lwf;

/**
 * author Administrator
 * time 2019-07-24
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE << 1);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE << 1));
        System.out.println(Integer.toBinaryString(-32));
        System.out.println(Integer.toBinaryString(-1<<0));
    }

    /**
     * 在32位时运行超时。
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int rtn=0;
        int length=0;
        while (n!=0){
            if((n&1)==0){
               rtn= rtn<<1;
            }else{
                rtn=(rtn<<1   )|1;
            }
           n=n>>1;
            length++;
        }
        return rtn<<(32-length);
    }

    /**
     * 通过测试，所以添加了length导致运行超时？
     * @param n
     * @return
     */
    public int reverseBits1(int n) {
        int rtn=0;

        for (int i = 0; i < 32; i++) {
            rtn=rtn>>1|(n&1);
            n=n<<1;
        }
        return rtn;
    }
}
