package com.lwf.TOP100.normal;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-10-21-22:04
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths1(51, 9));
    }

    /**
     * 动态规划在递归层数过深时的超时
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        backTracking(m,n,1,1);
        return paths;
    }
    int paths=0;
    void backTracking(int m,int n,int x,int y){
        if (x>=m||y>=n){
            paths++;
        }else{
            int newX=x+1;
            backTracking(m,n,newX,y);
            backTracking(m,n,x,++y);
        }
    }

    /**
     * 排列组合的溢出问题
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m,int n){
       long sum=m+n-2;
       long x=m-1;
       long y=n-1;
       long sums=sum;
       while (--sum>0){
           sums*=sum;
       }
       long xs=x;
       while(--x>0){
           xs*=x;
       }
        long ys=y;
        while(--y>0){
            ys*=y;
        }
        return (int)( sums/(xs*ys));
    }


    public int uniquePaths2(int m,int n){
       int[][] map=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0||j==0){
                    map[i][j]=1;
                }else{
                    map[i][j]=map[i-1][j]+map[i][j-1];
                }
            }
        }
        return map[m-1][n-1];

    }
    public int uniquePaths3(int m,int n) {
        int [] c=new int[n];
        Arrays.fill(c,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <n ; j++) {
                c[j]+=c[j-1];
            }
        }
        return c[n-1];

    }


}
