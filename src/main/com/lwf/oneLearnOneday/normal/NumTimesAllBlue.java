package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/6/14 9:24
 */
public class NumTimesAllBlue {

    class Solution {
        public int numTimesAllBlue(int[] flips) {
            // marks数组记录每个点的信息
            int[] marks=new int[flips.length];

            // sum记录从0到当前i被翻转的点之和,ans记录sum长度==i的次数
            int sum=0,ans=0;

            // 遍历flips数组
            for (int i = 0; i < flips.length; i++) {

                // 设置当前被翻转点
                marks[flips[i]]=1;

                // sum表示的是从0开始到i的所有被翻转的点的和，因此我们先sum+当前i
                sum+=marks[i];

                // 如果当前翻转的flips[i]小于i,则在sum中再增加1，因为flips[i]表示的是i之前的点，
                // sum之前加这个点时它是0，每次变化的在0~i之间都需要加上
                if (flips[i]<i)sum++;

                // 如果sum==i+1,即表示1到i所有灯号都被翻转过,ans++
                if (sum==i+1){
                    ans++;
                }
            }
            return ans;
        }
    }
}
