package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2300. 咒语和药水的成功对数
 * https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/?envType=daily-question&envId=2023-11-01
 * @author liuwenfei
 * @date 2023/11/10 9:15
 */
public class SuccessfulPairs {
    /**
     * 二分查找
     */
    class Solution1 {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int[] ans=new int[spells.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=half(spells[i],potions,success);
            }
            return ans;
        }
        public int half(int x,int[] potions,long success){
            int i=0,j=potions.length-1;
            //单调增，找>=的下标
            while (i<=j){
                int m=i+(j-i)/2;
                if ((long)x*potions[m]<success){
                    i=m+1;
                }else{
                    j=m-1;
                }
            }

            return potions.length-i;
        }
    }

    /**
     * 双指针
     */
    class Solution {
        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            Integer[] indez=new Integer[spells.length];
            for (int i = 0; i < indez.length; i++) {
                indez[i]=i;
            }
            Arrays.sort(indez,(a,b)->Integer.compare(spells[a],spells[b]));

            int[] ans=new int[spells.length];
            int pre=-1;
            for (int i = 0; i < indez.length; i++) {
                Integer index = indez[i];
                int cur = spells[index];
                if (pre==-1){
                    pre=half(cur,potions,success);

                }else{
                    int j=pre;

                    while (j>0&&(long)cur*potions[--j]>=success){

                    }
                    if (j==0&&(long)cur*potions[j]>=success){
                        pre=j;
                    }else{
                        pre=j+1;
                    }

                }
                    ans[index]=potions.length-pre;

            }
            return ans;
        }
        public int half(int x,int[] potions,long success){
            int i=0,j=potions.length-1;
            //单调增，找>=的下标
            while (i<=j){
                int m=i+(j-i)/2;
                if ((long)x*potions[m]<success){
                    i=m+1;
                }else{
                    j=m-1;
                }
            }

            return i;
        }
    }
}
