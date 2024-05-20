package com.lwf.oneLearnOneday.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 1542. 找出最长的超赞子字符串
 *
 * @author: liuwenfei
 * @date: 2024/5/20-8:26
 */
public class LongestAwesome {
    /**
     * 子串中的数字的奇偶性可以使用一个长度为10的数字进行记录，奇数为1，偶数位0，这样的话，就可以对这个数字进行记录，表示10个数字
     * 的不同组合情况，
     * 想要计算子串是否可回文，我们只要找到子串的头和尾i，j的数字，如果两个数字s[i]^s[j]==0或2……n次方，表示所有数字都是偶数个或者只有一个
     * 奇数个，这样就可以知道是否回文串。
     */
    class Solution {
        public int longestAwesome(String s) {
            Map<Integer,Integer> map=new HashMap<>();
            map.put(0,0);

            int pre=0,ans=0;
            for (int i = 0; i < s.length(); i++) {
                pre=(1<<(s.charAt(i)-'0'))^pre;

                if (Integer.bitCount(pre)==1||Integer.bitCount(pre)==0){
                    ans=Math.max(ans,i+1);
                }else {
                    //对每个数字排除一个后进行对比，如果有排除一个的组合，就可以进行子串记录
                    for (int i1 = 0; i1 < 10; i1++) {
                        ans=Math.max(ans,i-map.getOrDefault(pre^(1<<i1),s.length()));
                    }

                }
                map.putIfAbsent(pre,i);
            }
            return ans;
        }
    }
}
