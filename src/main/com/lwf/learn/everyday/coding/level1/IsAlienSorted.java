package com.lwf.learn.everyday.coding.level1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-10 15:23
 */
public class IsAlienSorted {
    class Solution {
        Map<Character,Integer> map=new HashMap<>();
        public boolean isAlienSorted(String[] words, String order) {

            for (int i = 0; i < order.length(); i++) {
                map.put(order.charAt(i),i);
            }
            for (int i = 0; i < words.length-1; i++) {
                if (compare(words[i],words[i+1])>0) {
                    return false;
                }
            }
            return true;
        }
        public int compare(String a,String b){
            char[] ca = a.toCharArray();
            char[] cb = b.toCharArray();
            int ia=0;
            int ib=0;
            while (ia<a.length()&&ib<b.length()&&Integer.compare( map.get( ca[ia]),map.get(cb[ib]))==0){
              ia++;
              ib++;
            }
            if (ia==a.length()||ib==b.length()){
                if (a.length()<b.length()){
                    return -1;
                }else if (a.length()==b.length()){
                    return 0;
                }else{
                  return 1;
                }
            }else{
                return Integer.compare( map.get( ca[ia]),map.get(cb[ib])) ;
            }
        }
    }
}
