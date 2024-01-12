package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. 统计出现过一次的公共字符串
 * @author liuwenfei
 * @date 2024/1/12 8:46
 */
public class CountWords {
    /**
     * 直接计数
     */
    class Solution {
        public int countWords(String[] words1, String[] words2) {
            Map<String,Integer> count1=new HashMap<>();
            for (int i = 0; i < words1.length; i++) {
                count1.compute(words1[i],(k,v)->((v==null?0:v)+1));
            }
            int ans=0;
            for (int i = 0; i < words2.length; i++) {
                //仅仅出现一次，否则不能算
                if (count1.containsKey(words2[i])&&count1.get(words2[i])<2) {
                    count1.computeIfPresent(words2[i],(k,v)->v-1);
                    if (count1.get(words2[i])==0){
                        ans++;
                    }else if (count1.get(words2[i])==-1){
                        ans--;
                    }
                }

            }
            return ans;
        }
    }
}
