package com.lwf.TOP100.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 * 954. 二倍数对数组
 * @author: liuwenfei14
 * @date: 2022-04-01 09:37
 */
public class CanReorderDoubled {
    public static void main(String[] args) {
        new Solution().canReorderDoubled(new int[]{2,1,2,1,1,1,2,2});
    }

    /**
     * hash+数组遍历
     * 排序数组后进行遍历，对负数和正数分开进行计算，
     * 辅助使用map来保存和数，最后若map为空则表示所有配对成功。
     */
   static class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Arrays.sort(arr);
            int numForMinus=0;
            Map<Integer,Integer> map=new HashMap<>();
            boolean hasMinus=arr[0]<0;
            for (int i = 0; i < arr.length; i++) {
                int currentNum = arr[i];

                if (currentNum<0){
                    if (map.keySet().contains(2*currentNum)) {
                        Integer count = map.get(2 * currentNum);
                        if (count==1){
                            map.remove(2*currentNum);
                        }else {
                            map.put(2*currentNum,count-1);
                        }
                        numForMinus--;
                    }else{
                        if ((currentNum%2)!=0){
                            return false;
                        }else{
                            if (map.containsKey(currentNum)){
                                map.put(currentNum,map.get(currentNum)+1);
                            }else{

                                map.put(currentNum,1);
                            }
                            numForMinus++;
                        }
                    }
                }else{
                    if (hasMinus&& numForMinus>0){
                        return false;
                    }
                    if (map.keySet().contains(currentNum)) {
                        Integer count = map.get(currentNum);
                        if (count==1){
                            map.remove(currentNum);
                        }else {
                            map.put(currentNum,count-1);
                        }
                    }else{
                        if (map.containsKey(2*currentNum)){
                            map.put(2*currentNum,map.get(2*currentNum)+1);
                        }else {

                            map.put(2*currentNum,1);
                        }
                    }
                }

            }
            return map.isEmpty();
        }
    }
}
