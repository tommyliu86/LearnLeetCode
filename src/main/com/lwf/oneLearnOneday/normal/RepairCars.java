package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/9/7 8:50
 */
public class RepairCars {
    /**
     * 正向思路是我们直接考虑如何分配车给工人 ，但是这样想是没法解的，
     * 正难则反，因此我们需要反向 思考如何做
     * 考虑，如果给定一个时间，则一个工人能修理多少汽车是可以直接计算出来的。num*num = time/r
     * 因此这时的题目变成了直接给时间，来计算是否可行。
     * 注意：由于 cars>=1 因此一个人做的时间肯定会大于两个人做，因此上界可以任意取一个人的时间即可。
     */
    class Solution {
        public long repairCars(int[] ranks, int cars) {

            long max =  ((long) cars*cars * ranks[ranks.length - 1]) ;
            long min=1;
            while (min<max){
                long mid=min+ ((max-min)/2);
                if (calc(ranks,cars,mid)){
                    max=mid;
                }else{
                    min=mid+1;
                }
            }
            return min;
        }

        private boolean calc(int[] ranks, int cars, long mid) {
            long sum=0;
            for (int rank : ranks) {
               sum+= Math.sqrt(mid / rank);
            }

            return sum>=cars;
        }
    }
}
