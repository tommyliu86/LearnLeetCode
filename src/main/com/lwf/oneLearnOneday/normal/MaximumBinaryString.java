package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 1702. 修改后的最大二进制字符串
 *
 * @author: liuwenfei
 * @date: 2024/4/10-8:42
 */
public class MaximumBinaryString {
    /**
     * 双指针，找零大法，先第一个零，然后向后找第二个零，如果我们有两个零，那么我们第二个零可以向前移动最终一定可以合并到一起！
     * 011110-》001111-》101111、
     * 那么剩下的其实就是找到最后一个零的位置要在哪里，我们统计所有的0的个数，然后找到第一个零的位置i，那么最后一个0的位置就是i+count-1；
     */
    class Solution {

        public String maximumBinaryString(String binary) {
            char[] chars = binary.toCharArray();
            int count0 = 0;
            int i = chars.length;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '0') {
                    i = Math.min(i, j);
                    count0++;
                }
            }
            if (count0<2){
                return binary;
            }else{
                Arrays.fill(chars,'1');
                chars[i+count0-1]='0';
                return String.valueOf(chars);
            }
        }
    }
}
