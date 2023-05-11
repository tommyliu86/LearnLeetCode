package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/5/11 9:05
 */
public class SmallestRepunitDivByK {
    /**
     * 余数 除余 和本数除余得到的结果是一样的， 因此这样可以让被除数不会溢出
     */
    class Solution {
        public int smallestRepunitDivByK(int k) {
            if (k%2==0||k%5==0)return -1;
            int l=0;
            int m=1;
            Map<Integer,Integer> map=new HashMap<>();
            while (m%k!=0){
                int remainder = m % k;
                if (map.containsKey(remainder))return -1;
                map.put(remainder,l);
                m=m*10+1;

            }
            return l+1;
        }
    }
}
