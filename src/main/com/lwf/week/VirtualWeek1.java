package com.lwf.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/10/5 22:16
 */
public class VirtualWeek1 {
    class Solution {
        public int deleteString(String s) {
            char[] chars = s.toCharArray();
            boolean allChar=true;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i]!=chars[i-1]) {
                    allChar=false;
                    break;
                }
            }
            if (allChar){
                return s.length();
            }
            List<Integer>[] marks=new List[26];
            for (int i = 0; i < marks.length; i++) {
                marks[i]=new ArrayList<>();
            }
            int[] steps=new int[chars.length];
            Arrays.fill(steps,1);
            for (int i = chars.length - 1; i >= 0; i--) {
                char aChar = chars[i];
                List<Integer> list = marks[aChar - 'a'];
                int max=0;
                for (int j = 0; j < list.size(); j++) {
                    Integer nextIndex = list.get(j);
                    if (nextIndex+(nextIndex-i)<s.length()&& s.substring(i,nextIndex).equals(s.substring(nextIndex,nextIndex+(nextIndex-i)))){
                        max=Math.max(1+steps[nextIndex],max);
                    }
                }
                steps[i]=max;
                marks[aChar-'a'].add(i);
            }
            return steps[0];
        }
    }
     class Solution3 {
        public int minimizeXor(int num1, int num2) {
            int count2=Integer.bitCount(num2);
            int count1=Integer.bitCount(num1);
            if (count1==count2){
                return num1;
            }
            if (count2<count1){
                int ans=num1;
                int i=count1-count2;
                while (i>0){
                    ans=ans&(ans-1);
                    i--;
                }
                return ans;
            }else{
                int i=count2-count1;
                int ans=num1;
                int bit=0;
                while (i>0){
                    while ((ans&(1<<bit))==(1<<bit)){
                        bit++;
                    }
                    ans=(ans|(1<<bit));
                    bit++;
                    i--;
                }
                return ans;
            }

        }
    }
    class Solution2 {
        public int maxSum(int[][] grid) {
            int m=grid.length,n=grid[0].length;
            int[][] sums=new int[m+1][n+1];
            for (int i = 1; i < sums.length; i++) {
                for (int j = 1; j < sums[i].length; j++) {
                    sums[i][j]=sums[i-1][j]+sums[i][j-1]+grid[i-1][j-1]-sums[i-1][j-1];
                }
            }
            int max=0;
            for (int i = 3; i < sums.length; i++) {
                for (int j = 3; j < sums[i].length; j++) {
                    int cur=sums[i][j]-sums[i-3][j]-sums[i][j-3]+sums[i-3][j-3] -grid[i-2][j-1]-grid[i-1][j-3];
                    max=Math.max(cur,max);
                }
            }
            return max;

        }
    }
    class Solution1 {
        public int commonFactors(int a, int b) {
            int ans=0;
            for (int i = 1; i < 1001; i++) {
                if (a%i==0&&b%i==0){
                    ans++;
                }
            }
            return ans;
        }
    }
}
