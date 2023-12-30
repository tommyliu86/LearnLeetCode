package com.lwf.classic.two;

/**
 * @author liuwenfei
 * @date 2023/2/17 9:31
 */
public class Divide {
    //递归会导致stackoverflow，因此换成迭代，迭代也会超时，这里需要考虑如何折半。
    class Solution {
        public int divide(int a, int b) {
            if (a==0) return 0;
            if (a==b) return 1;
            if (b==Integer.MIN_VALUE) return 0;
            if (a == Integer.MIN_VALUE && b == -1) {
                return Integer.MAX_VALUE;
            }
            int amark=a>0?1:-1;
            int bmark=b>0?1:-1;
            //这里把a和b都转成负数，这样不会有超出边界的情况,同时需要考虑边界情况，也就是a=min_value,b=-1,这时的结果会超过max_value！
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


    }
    //递归会导致stackoverflow，因此换成迭代，迭代也会超时，这里需要考虑如何折半。
    class Solution2 {
        public int divide(int a, int b) {
            if (a==0) return 0;
            if (a==b) return 1;
            if (b==Integer.MIN_VALUE) return 0;
            int amark=a>0?1:-1;
            int bmark=b>0?1:-1;
            int n=0,newA=0;
            boolean ok=true;
            while (ok=amark<0?a<=(amark*bmark)*newA:a>=(amark*bmark)*newA){
                newA+=b;
                n++;
            }
            return amark*bmark*(n-1);
        }

    }
    //递归会导致stackoverflow，因此换成迭代
    class Solution1 {
        public int divide(int a, int b) {
            if (a==0|| b==Integer.MIN_VALUE) return 0;
            int step=-1;
            if ((a>0&&b>0)||(a<0&&b<0)) {
                step=1;
            }

            int newA = a + (-1 * step) * b;
            if ((newA>0&&a<0)||(newA<0&&a>0)){
                return 0;
            }
            return step+divide(newA,b);
        }

    }
}
