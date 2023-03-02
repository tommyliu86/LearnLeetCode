package com.lwf.offer.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/3/2 9:22
 */
public class FindMaxLength {
    /**
     * 变换数组后的前缀和,hash保存 前缀和，和表示的是目前多了几个0或1，因此使用hash保存前面的出现过的下标最小的和
     * 就是最大长度
     */
    class Solution {
        public int findMaxLength(int[] nums) {
            int[] n=new int[nums.length];
            for (int i = 0; i < n.length; i++) {
                n[i]=nums[i]==1?1:-1;
            }
            int[] sum=new int[nums.length+1];
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,0);
            int ans=0;
            for (int i = 1; i < sum.length; i++) {
                sum[i]=sum[i-1]+n[i-1];
                if (map.containsKey(sum[i])) {
                    ans=Math.max(ans,i-map.get(sum[i]));
                }else{
                    map.put(sum[i],i);
                }

            }
            return ans;
        }
    }

    /**
     * 前缀和+暴力法，超时
     * 这里的前缀和只保存了1的个数，这样的话，想要快速获取对应的坐标，值可以满足 l（j-i）=（j-i）*2  会比较困难
     */
    class Solution1 {
        public int findMaxLength(int[] nums) {
            int[] lens = new int[nums.length + 1];


            int max = 0;
            for (int i = 1; i < lens.length; i++) {
                lens[i] = lens[i - 1] + (nums[i - 1] & 1);
                for (int j = i % 2; j < i; j += 2) {
                    if ((lens[i] - lens[j]) * 2 == i - j) {
                        max = Math.max(i - j, max);
                        break;
                    }
                }
            }
            return max;
        }
    }
}
