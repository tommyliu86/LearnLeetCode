package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2580. 统计将重叠区间合并成组的方案数
 * @author: liuwenfei
 * @date: 2024/3/27-20:46
 */
public class CountWays {
    public static void main(String[] args) {
        int[][] datas= {
                {57, 92}, {139, 210}, {306, 345}, {411, 442}, {533, 589}, {672, 676},
                {801, 831}, {937, 940}, {996, 1052}, {1113, 1156}, {1214, 1258},
                {1440, 1441}, {1507, 1529}, {1613, 1659}, {1773, 1814}, {1826, 1859},
                {2002, 2019}, {2117, 2173}, {2223, 2296}, {2335, 2348}, {2429, 2532},
                {2640, 2644}, {2669, 2676}, {2786, 2885}, {2923, 2942}, {3035, 3102},
                {3177, 3249}, {3310, 3339}, {3450, 3454}, {3587, 3620}, {3725, 3744},
                {3847, 3858}, {3901, 3993}, {4100, 4112}, {4206, 4217}, {4250, 4289},
                {4374, 4446}, {4510, 4591}, {4675, 4706}, {4732, 4768}, {4905, 4906},
                {5005, 5073}, {5133, 5142}, {5245, 5309}, {5352, 5377}, {5460, 5517},
                {5569, 5602}, {5740, 5791}, {5823, 5888}, {6036, 6042}, {6096, 6114},
                {6217, 6262}, {6374, 6394}, {6420, 6511}, {6564, 6587}, {6742, 6743},
                {6797, 6877}, {6909, 6985}, {7042, 7117}, {7141, 7144}, {7276, 7323},
                {7400, 7456}, {7505, 7557}, {7690, 7720}, {7787, 7800}, {7870, 7880},
                {8013, 8031}, {8114, 8224}, {8272, 8328}, {8418, 8435}, {8493, 8537},
                {8600, 8704}, {8766, 8812}, {8839, 8853}, {9032, 9036}, {9108, 9189},
                {9222, 9291}, {9344, 9361}, {9448, 9502}, {9615, 9673}, {9690, 9800},
                {9837, 9868}, {85, 96}, {145, 202}, {254, 304}, {372, 411}, {534, 551},
                {629, 692}, {727, 787}, {861, 944}, {1041, 1084}, {1133, 1174}, {1260, 1307},
                {1339, 1358}, {1478, 1548}, {1580, 1618}, {1694, 1814}, {1848, 1891},
                {1936, 1990}, {2058, 2130}
        };

        countWays(datas);
    }
    /**
     * 对数组进行排序后，按照交集进行分组，获取到组数的总数之后，直接计算即可
     * 额。不需要进行计算阶层，直接按照二分法，每个交集选择能够放到哪个分组去就行。。。。
     * 思路：每多一个子集，它能放入的是左边，或者右边，因此是前面计算的2倍。
     */
    class Solution {
        public int countWays(int[][] ranges) {
            Arrays.sort(ranges,(a,b)->Integer.compare(a[0],b[0]));
            long count=0;
            int i=0;
            while (i<ranges.length){
                int[] cur = ranges[i];
                int end=cur[1];
                while (++i<ranges.length&&ranges[i][0]<=end){
                    end=Math.max(end,ranges[i][1]);
                }
                count=(count*2)%mod;
            }
          return (int) count;
        }
         int mod=1000_000_007;


    }

    public static int countWays(int[][] ranges) {
        Arrays.sort(ranges,(a,b)->Integer.compare(a[0],b[0]));
        long count=0;
        int i=0;
        while (i<ranges.length){
            int[] cur = ranges[i];
            int end=cur[1];
            while (++i<ranges.length&&ranges[i][0]<=end){
                end=Math.max(end,ranges[i][1]);
            }
            count++;
        }
        long sum=0;
        //得到了所有的子集
        //计算从子集中从0，取到n的情况
        for (int l = 0; l <= count; l++) {
            sum=(sum+combination(count,l))%mod;
        }
        return (int) sum;
    }
   static int mod=1000_000_007;
        // 计算阶乘的方法 只能计算n比较小的时候，不然会溢出！
        public static long factorial(long n) {
            if (n <= 1) {
                return 1;
            }
            return n * factorial(n - 1);
        }

        // 计算组合数的方法
        public static long combination(long n, long m) {
            return factorial(n) / (factorial(m) * factorial(n - m));
        }
}
