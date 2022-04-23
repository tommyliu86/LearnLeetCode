package com.lwf.arithmetic.level1.number;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-19 18:43
 */
public class RomanToInt {

    class Solution {
        public int romanToInt(String s) {
            Map<Character, Integer> map=new HashMap<>();
            for (int i = 0; i < roam.length; i++) {
                map.put(roam[i],nums[i]);
            }
            char[] chars = s.toCharArray();
            int rtn=0;
            int pre=0;
            for (int i = chars.length - 1; i >= 0; i--) {
                Integer integer = map.get(chars[i]);
                if (integer<pre){
                    rtn-=integer;
                }else{
                    rtn+=integer;
                }
                pre=integer;
            }
            return rtn;

        }

        char[] roam=new char[]{'I',
                'V',
                'X',
                'L',
                'C',
                'D',
                'M'};
        int[] nums=new int[]{1,5,10,50,100,500,1000};
    }
}
