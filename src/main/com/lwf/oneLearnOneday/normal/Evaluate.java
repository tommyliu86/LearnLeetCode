package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/1/12 8:28
 */
public class Evaluate {
    /**
     * 哈希表保存k-v
     */
    class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String,String> map=new HashMap<>();
            for (List<String> strings : knowledge) {
                map.put(strings.get(0),strings.get(1));
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i=0;
            while (i<s.length()){
                if (s.charAt(i)!='('){
                    stringBuilder.append(s.charAt(i));
                    i++;
                }else{
                    int left=i+1;
                    while (s.charAt(i)!=')'){
                        i++;
                    }
                    stringBuilder.append(map.getOrDefault(s.substring(left,i++),"?"));
                }
            }
            return stringBuilder.toString();
        }
    }
}
