package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * 蓄水池抽样算法，在未知大小的总体中等概率选取m个元素：
 * 1.如果接收的数据量小于m，则依次放入蓄水池。
 * 2.当接收到第i个数据时，i >= m，在[0, i]范围内取以随机数d，若d的落在[0, m-1]范围内，则用接收到的第i个数据替换蓄水池中的第d个数据。
 * 3.重复步骤2。
 * 算法的精妙之处在于：当处理完所有的数据时，蓄水池中的每个数据都是以m/N的概率获得的。
 *

 * @author: liuwenfei14
 * @date: 2022-04-25 09:13
 */
public class RandomSolution {
    class test {
        int[] nums;
        Random random;

        public test(int[] nums) {
            nums=nums;
            random=new Random();
        }

        public int pick(int target) {
            int cur=0;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==target){
                    count++; //target出现了几次了
                    if (random.nextInt(count)==0){ //蓄水池算法，在n（target个数）个数里面选1个。若选中第一个，则交换，也即是随机返回的数
                        cur=i;
                    }
                }

            }
            return cur;
        }
    }
    class Solution {
        Map<Integer, List<Integer>> map;
        Random random;

        public Solution(int[] nums) {
            map=new HashMap<>();
            random=new Random();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<Integer>());
                orDefault.add(i);
                map.put(nums[i],orDefault);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
