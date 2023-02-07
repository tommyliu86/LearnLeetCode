package com.lwf.oneLearnOneday.normal;

import java.util.*;
import java.util.jar.JarEntry;

/**
 * @author liuwenfei
 * @date 2023/2/7 9:02
 */
public class AlertNames {
    /**
     * 不排序，直接统计每个员工所有时间，然后每个员工进行统计看是否有警告：滑动窗口+计数
     */
    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> names = new HashMap<>();
            for (int i = 0; i < keyTime.length; i++) {
                String name = keyName[i];
                List<Integer> list = names.getOrDefault(name, new ArrayList<Integer>());
                list.add(parseInt(keyTime[i]));
                names.put(name, list);
            }
            List<String> ans = new ArrayList<>();
            names.forEach((k, v) -> {
                v.sort(Integer::compareTo);
                for (int i = 2; i < v.size(); i++) {
                    if (v.get(i) - v.get(i - 2) <= 60) {
                        ans.add(k);
                        break;
                    }
                }
            });
            ans.sort(String::compareTo);
            return ans;
        }

        private int parseInt(String right) {
            String[] split = right.split(":");
            int rights = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            return rights;
        }
    }
    /**
     * 排序+滑动窗口+计数
     */
    class Solution1 {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            int[] keyTimes=new int[keyTime.length];
            for (int i = 0; i < keyTimes.length; i++) {
                keyTimes[i]=parseInt(keyTime[i]);
            }
            Integer[] indexs=new Integer[keyTime.length];
            for (int i = 0; i < indexs.length; i++) {
                indexs[i]=i;
            }
            Arrays.sort(indexs,  Comparator.comparing(a -> keyTimes[a]));
            Arrays.sort(keyTimes);
            Map<String,Integer> map=new HashMap<>();
            int i=0;
            int left=0;
            Set<String> names=new HashSet<>();
            while (i<keyTimes.length){
                int time = keyTimes[i];
                String name = keyName[indexs[i]];
                if (names.contains(name)){
                    i++;
                    continue;
                }
                while (time-keyTimes[left]>60){
                    String leave = keyName[indexs[left]];
                    if (!names.contains(leave)){
                        map.put(leave,map.get(leave)>0?map.get(leave)-1:0);
                    }
                    left++;
                }
                map.put(name,map.getOrDefault(name,0)+1);
                if (map.get(name)>=3){
                    names.add(name);
                    map.put(name,0);
                }
                i++;
            }
            List<String> ans=new ArrayList<>();
            ans.addAll(names);
            ans.sort(String::compareTo);
            return ans;
        }
        private int parseInt(String right){
            String[] split = right.split(":");
            int rights=Integer.parseInt( split[0])*60+Integer.parseInt(split[1]);
           return rights;
        }
    }
}
