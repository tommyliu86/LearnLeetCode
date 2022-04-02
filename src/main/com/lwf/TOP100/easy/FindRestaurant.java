package com.lwf.TOP100.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * 599. 两个列表的最小索引总和
 * @author: liuwenfei14
 * @date: 2022-03-17 18:34
 */
public class FindRestaurant {
    /**
     * 借助map来进行数据保存
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        int minSum=Integer.MAX_VALUE;
        List<Integer> index=new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])){
                Integer index1 = map.get(list2[i]);
                if (minSum>index1+i){
                    minSum=index1+i;
                    index.clear();
                    index.add(i);
                }else if(minSum==index1+i){
                    index.add(i);
                }
            }
        }

            String[] rtn=new String[index.size()];
            for (int i = 0; i < index.size(); i++) {
                rtn[i]=list2[index.get(i)];
            }
            return rtn;

    }
}
