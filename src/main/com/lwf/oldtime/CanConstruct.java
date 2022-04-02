package com.lwf.oldtime;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-08-06
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()) return false;
        char[] rs=ransomNote.toCharArray();
        char[] ms=magazine.toCharArray();
        Map<Character,Integer> map=new LinkedHashMap<>();
        for (char m : ms) {
            if (map.containsKey(m)){
                map.put(m,map.get(m)+1);
            }else {
                map.put(m,1);
            }
        }
        for (char r : rs) {
            if (map.containsKey(r)&&map.get(r)>1){
                map.put(r,map.get(r)-1);
            }else   {
                return false;
            }

        }
        return true;
    }
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()) return false;
        char[] rs=ransomNote.toCharArray();
        char[] ms=magazine.toCharArray();
        int[] nums=new int[26];
        for (char m : ms) {
            nums[(m-'a')]++;
        }
        for (char r : rs) {
            if (nums[r-'a']>0){
               nums[r-'a']--;
            }else   {
                return false;
            }

        }
        return true;
    }
}
