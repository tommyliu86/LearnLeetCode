package com.lwf.learn.everyday.data.level2.d2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 17:46
 */
public class FindRepeatedDnaSequences {
    /**
     * 位运算的优先级是最低的，因此在计算时注意使用括号！！
     */
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> rtn=new HashSet<>();
            if (s.length()<10){
                return new ArrayList<>();

            }
            Map<Character,Integer> map=new HashMap<>();
            map.put('A',0);
            map.put('C',1);
            map.put('G',2);
            map.put('T',3);
            Map<Integer,String> keys=new HashMap<>();
            char[] chars = s.toCharArray();
            int left=0;
            int right=0;


            int key=0;
            while (right<chars.length){
                while (right-left+1<=10){
                    char aChar = chars[right];
                    key= ((key<<2)&((1<<20)-1) )+map.get(aChar);
                    right++;
                }
                if (keys.containsKey(key)){
                    rtn.add(keys.get(key));
                }else{
                    keys.put(key,s.substring(left,right));
                }
                left++;

            }
            return new ArrayList<>( rtn);
        }
    }
}
