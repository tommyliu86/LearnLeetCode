package com.lwf.classic.one;

/**
 * @author liuwenfei
 * @date 2023/1/30 14:36
 */
public class MovingCount {
    class Solution {
        int[][] steps={{1,0},{-1,0},{0,-1},{0,1}};
        public int movingCount(int m, int n, int k) {
            int[][] marks=new int[m][n];
            return count(0,0, m,n,k,marks);
        }
        private int count(int x,int y, int m,int n,int k,int[][] marks){
            int count=0;
            if(calc(x)+calc(y)<=k){
                count++;
                marks[x][y]=1;
                for (int i = 0; i < steps.length; i++) {
                    int[] step = steps[i];
                    int nx=x+step[0];
                    int ny=y+step[1];
                    if (nx>=0&&nx<m&&ny>=0&&ny<n&&marks[nx][ny]==0){
                        count+=count(nx,ny, m,n,k,marks);
                    }
                }
            }
            return count;
        }
        private int calc(int x){
            int ans=0;
            while (x != 0) {
                ans+=x%10;
                x/=10;
            }
            return ans;
        }
    }
}
