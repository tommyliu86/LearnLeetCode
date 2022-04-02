package com.lwf.oldtime;

import java.util.*;

/**
 * author Administrator
 * time 2019-08-31-23:30
 */
public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        List<String> rtn=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])){
                int count=i+map.get(list2[i]);
                if (count<min){
                    min=count;
                    rtn.clear();
                    rtn.add(list2[i]);
                }
                else if(count==min){
                    rtn.add(list2[i]);
                }
            }
        }
        String[] rtns=new String[rtn.size()];
        for (int i = 0; i < rtns.length; i++) {
            rtns[i]=rtn.get(i);
        }
        return rtns;
    }
}
