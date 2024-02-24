package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2808. 使循环数组所有元素相等的最少秒数
 * 灵神题解：https://leetcode.cn/problems/minimum-seconds-to-equalize-a-circular-array/solutions/2374938/ba-wen-ti-kan-cheng-shi-kuo-san-yuan-su-jddr9/?envType=daily-question&envId=2024-01-30
 *
 * @author liuwenfei
 * @date 2024/1/30 8:38
 */
public class MinimumSeconds {
    /**
     * 关键思路，把问题看成是把x进行扩散的过程，每个x每一秒都可以向左右进行扩散，最后找到每个不同的x的扩散到最远的时间就行！
     * 这个思路太精确了
     */
    class Solution {
        public int minimumSeconds(List<Integer> nums) {
            int n = nums.size();
            Map<Integer,List<Integer>> indez=new HashMap<>();
            for (int i = 0; i < n; i++) {
                //算法题目中尽量不要用funcation！会导致内存溢出。。。
                indez.computeIfAbsent(nums.get(i), k->new ArrayList<>()).add(i);
            }
            int ans= n;
            //对于下标列表，其中的index值已经是排序好的，因此我们通过遍历计算每两个之间的距离，取最大值即可
            for (List<Integer> list : indez.values()) {
                //两端的距离
                int max= n -list.get(list.size()-1)+list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    max=Math.max(max,list.get(i)-list.get(i-1));
                }
                ans=Math.min(max/2,ans);
            }
            return ans;
        }
    }
}
