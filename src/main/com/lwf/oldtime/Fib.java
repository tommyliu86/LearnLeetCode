package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-21-22:14
 * {@link 509.md}
 */
public class Fib {
    public int fib(int N) {
        if (N == 0 || N == 1) return N;
        else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    public int fib1(int N) {
        if (N==0) return 0;
        int f = 0;
        int s = 1;
        int t;
        int index = 1;
        while (index < N) {
            t = s;
            s = f + s;
            f = t;
            index++;
        }
        return s;
    }
}
