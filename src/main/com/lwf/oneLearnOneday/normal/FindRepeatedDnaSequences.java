package com.lwf.oneLearnOneday.normal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 187. 重复的DNA序列
 * https://leetcode.cn/problems/repeated-dna-sequences/?envType=daily-question&envId=2023-10-30
 * @author liuwenfei
 * @date 2023/11/6 8:51
 */
public class FindRepeatedDnaSequences {
    /**
     * 位运算
     * 使用两位数字来表示 4个位，这样就可以进行位运算了
     */
    class Solution {
        Map<Character,Integer> map=new HashMap<>(){
             {
                put('A',0);
                put('C',1);
                put('G',2);
                put('T',3);
            }
        };
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length()<=10)return Collections.emptyList();
            Set<Integer> set=new HashSet<>();
            int i=0,j=0;
            int cur=0;
            Set<String> ans=new HashSet<>();
            while (j<s.length()){
                while (j-i<10){
                  cur=  (cur<<2)|map.get(s.charAt(j));
                  j++;
                }
                if (set.contains(cur)){
                    ans.add(s.substring(i,j));
                }else{
                    set.add(cur);
                }
                cur&=(1<<18)-1;
                i++;
            }
            return  ans.stream().collect(Collectors.toList());
        }
    }
}
