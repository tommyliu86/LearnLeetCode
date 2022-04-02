package com.lwf.oldtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Administrator
 * time 2019-08-13
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (char c : p.toCharArray()) {
            sum += c;
            map.put(c + 0, map.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = 0;
        int asum = 0;

        while (start <= (s.length() - p.length()) && end < s.length()) {
            if (!map.containsKey(s.charAt(end) + 0)) {
                start = ++end;
                asum = 0;
            } else {
                asum += s.charAt(end);
                if (end - start + 1 < p.length()) {
                    if (asum >= sum) {
                        asum -= s.charAt(start++);
                    }
                } else {
                    if (asum == sum)
                        list.add(start);
                    asum -= s.charAt(start++);
                }
                end++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams1("af", "be"));
    }
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list=new ArrayList<>();
        if (s.length()<p.length()) return list;
        int sum=0;
        int[] chars=new int[26];
        for (char c : p.toCharArray()) {
            sum+=c;
            chars[c-'a']+=1;
        }
        int[] sumList=new int[s.length()+1];
        sumList[0]=0;
        int start=0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)-'a']==0) {
                start=i+1;
            }
            sumList[i+1]=sumList[i]+s.charAt(i);
            if (i+1-start>=p.length()&&sumList[i+1]-sumList[i+1-p.length()]==sum){
                list.add(i+1-p.length());
            }
        }
        return list;
    }
}
