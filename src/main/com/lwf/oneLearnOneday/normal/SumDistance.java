package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/10/10 8:59
 */
public class SumDistance {
    class Solution {
        /**
         * 脑筋急转弯 。碰撞后变相，相当于直接穿过，也就是直接考虑 L  R 即可
         *
         * 求距离，直观想法是找到每个i ，往后的所有位置组成 距离对，其实也可以反过来，用i和每个 i 之前的位置组成距离对，这样，i+1的 值可以直接使用
         * dis(i+1）-dis(i) 来求解！ 因此需要排序
         *
         * @param nums
         * @param s
         * @param d
         * @return
         */
        public int sumDistance(int[] nums, String s, int d) {
            long[] dis=new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dis[i]=(long) nums[i]+(s.charAt(i)=='L'?-1:1)*d;
            }
            long mod=1000_000_007;
            Arrays.sort(dis);
            long ans=0, sum=0;

            for (int i = 0; i < dis.length; i++) {
                //用前缀和来进行计算
                ans=(ans+ i*dis[i]-sum)%mod;
                sum+=dis[i];
            }
            return (int) ans;
        }
        public int sumDistance1(int[] nums, String s, int d) {
            long[] dis=new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dis[i]=(long) nums[i]+(s.charAt(i)=='L'?-1:1)*d;
            }
            long mod=1000_000_007;
            Arrays.sort(dis);
            long ans=0, sum=0;
            //使用累加变化值 dis[i]-dis[i-1] 来计算时，需要 明确 哪些距离对增加了 这个距离  是 所有和dis[i-1] 产生关系的。
            for (int i = 1; i < dis.length; i++) {
              ans+=   (dis[i] - dis[i - 1]) * i % mod * (nums.length - i) % mod;
              ans%=mod;
            }
            return (int) ans;
        }
    }
}
