package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-27 08:45
 */
public class FindClosest {
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            int i1=-1;
            int i2=-1;
            int min=words.length;
            for (int i = 0; i < words.length; i++) {
                boolean change=false;
                if (words[i].equals(word1)){
                    change=true;
                    i1=i;
                }else if (words[i].equals(word2)){
                    change=true;
                    i2=i;
                }
                if (change&&i1!=-1&&i2!=-1){
                    min=Math.min(Math.abs( i1-i2),min);
                }
            }
            return min;
        }
    }

    /**
     * 进阶处理，预处理字典数组，构建一个map来保存所有的单词下标list，这样可以在多次查询时，直接利用map缓存来查到下标。
     * 利用双指针查找下标间的最下距离
     */
    class Solution1 {
        public int findClosest(String[] words, String word1, String word2) {
            Map<String, List<Integer>> map=new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
                list.add(i);
                map.put(words[i],list);

            }
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            return findmin(list1,list2);

        }
        public int findmin(List<Integer> list1,List<Integer> list2){
            list1.sort(Integer::compareTo);
            list2.sort(Integer::compareTo);

            int i1=0;
            int i2=0;
            int min=Integer.MAX_VALUE;
            while (i1<list1.size()&&i2<list2.size()){
                Integer l1 = list1.get(i1);
                Integer l2 = list2.get(i2);
                if (l1<l2){
                    min=Math.min(l2-l1,min);
                    i1++;
                }else{
                    min=Math.min(l1-l2,min);
                    i2++;
                }
            }
            return min;
        }
    }
}
