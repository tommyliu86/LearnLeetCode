package com.lwf.oneLearnOneday.easy;

/**
 * 2960. 统计已测试设备
 *
 * @author: liuwenfei
 * @date: 2024/5/11-8:19
 */
public class CountTestedDevices {
    /**
     * 逆向思维，让最小电池persent进行变大
     */
    class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int ans=0;
            int min=1;
            for (int bat : batteryPercentages) {
                if (bat>=min){
                    ans++;
                    min++;
                }
            }
            return ans;
        }
    }
}
