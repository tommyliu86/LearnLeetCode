package com.lwf.data;

/**
 * @author liuwenfei
 * @date 2023/2/17 11:27
 */
public class FastCalc {
    //快速除法，使用减数加倍，来和被减数-减数比较，实现快速折半减小，每次迭代都从减数的1倍开始，
    public int divide(int a, int b) {
        if (a==0) return 0;
        if (a==b) return 1;
        if (b==Integer.MIN_VALUE) return 0;
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int amark=a>0?1:-1;
        int bmark=b>0?1:-1;
        //这里把a和b都转成负数，这样不会有超出边界的情况
        a=a>0?-1*a:a;
        b=b>0?-1*b:b;
        int n=0;

        while (a<=b){
            int i=1;
            int cur=b;
            //用+法把被减数变大，同时a又减去了被减数，这样的化cur就会变成小于a的一半的数，实现折半
            while (cur>a-cur){
                cur+=cur;
                i+=i;
            }
            a-=cur;
            n+=i;
        }
        return amark*bmark*n;

    }
    //位运算加法，使用 （位数相同的与）<<1 表示是否有进位，（异或）来计算不存在进位的位数，剩下的就是两个迭代进位+，最后当进位==0时终止即可。
    public int add(int a, int b) {
        int adds=a&b;

        a=a^b;
        while (adds!=0){
            adds<<=1;
            int next=a^adds;
            adds=a&adds;
            a=next;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(multi(2, 10));
        System.out.println(multi(2, 11));
        System.out.println(multi(2, -10));
        System.out.println(multi(2, -11));
    }
    //快速乘，计算很简单，通过指数 是偶数可以变为 两个的乘积，来实现计算折半，这里注意符号表示的意思即可
    public static int multi(int a, int b) {
        if (a==0||b==0) return 0;

        if (b%2==0){
            int c;
            return (c=multi(a,b/2))+c;
        }else{
            int c;
            return (b>0?1:-1)*a+(c=multi(a,b/2))+c;
        }

    }
    //快速幂，计算很简单，通过指数 是偶数可以变为 两个的乘积，来实现计算折半，这里注意符号表示的意思即可
    public double myPow(double x, int n) {
        if (n==0) return 1d;
        double a=0;
        if (n>0){
            if (n%2==0){
                return  (a= myPow(x,n/2))*a;
            }else{
                return x*(a=myPow(x,(n-1)/2))*a;
            }
        }else{
            if (n%2==0){
                return (a=myPow(x,n/2))*a;
            }else{
                return (1/x)*(a=myPow(x,(n+1)/2))*a;
            }
        }

    }
}
