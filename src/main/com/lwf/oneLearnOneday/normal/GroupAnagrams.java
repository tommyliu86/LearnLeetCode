package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * author Administrator
 * time 2019-10-11-22:50
 * {@link md/normal/49.md}
 */
public class GroupAnagrams {
    public static void main(String[] args) {

        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"ins", "sin", "tan", "ate", "nat", "bat"}));
    }

    /**
     * false  why?
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //length-sum- ^
        int[] lens = new int[strs.length];
        int[] sums = new int[strs.length];
        int[] xors = new int[strs.length];

        ArrayList<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();

            char[] chars = strs[i].toCharArray();
            int sum = 0;
            int xor = 0;
            int[] indexs=new int[26];
            for (char aChar : chars) {
                indexs[aChar-'a']+=1;
                sum += aChar;
                xor = xor ^ aChar;
            }
            if (lists.size() == 0) {
                lens[0] = len;
                sums[0] = sum;
                xors[0] = xor;
                lists.add(0, new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                boolean add=true;
                for (int j = 0; j < lists.size(); j++) {
                    if (lens[j] == len && sums[j] == sum &&( xor ^ xors[j])==0) {

                        boolean fail=false;
                        char[] subchars=lists.get(j).get(0).toCharArray();
                        for (char subchar : subchars) {
                            if (indexs[subchar-'a']<1){
                                fail=true;
                                break;
                            }else{
                                indexs[subchar-'a']--;
                            }
                        }
                        if (!fail){

                            lists.get(j).add(strs[i]);
                            add=false;
                            break;
                        }
                    }
                }
                if (add){
                    int size = lists.size();
                    lens[size] = len;
                    sums[size] = sum;
                    xors[size] = xor;
                    lists.add(size, new ArrayList<>(Arrays.asList(strs[i])));
                }


            }
        }
        return lists;


    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        //length-sum- ^
        int[] lens = new int[strs.length];
        int[] sums = new int[strs.length];
        int[] xors = new int[strs.length];

        ArrayList<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();

            char[] chars = strs[i].toCharArray();
            int sum = 0;
            int xor = 0;
            for (char aChar : chars) {
                sum += aChar;
                xor = xor ^ aChar;
            }
            if (lists.size() == 0) {
                lens[0] = len;
                sums[0] = sum;
                xors[0] = xor;
                lists.add(0, new ArrayList<>(Arrays.asList(strs[i])));
            } else {
                boolean add=true;
                for (int j = 0; j < lists.size(); j++) {
                    if (lens[j] == len && sums[j] == sum &&( xor ^ xors[j])==0) {
                        int[] indexs=new int[26];
                        boolean fail=false;
                        char[] subchars=lists.get(j).get(0).toCharArray();
                        for (char aChar : chars) {
                            indexs[aChar-'a']+=1;
                        }
                        for (char subchar : subchars) {
                            if (indexs[subchar-'a']<1){
                                fail=true;
                                break;
                            }else{
                                indexs[subchar-'a']--;
                            }
                        }
                        if (!fail){

                            lists.get(j).add(strs[i]);
                            add=false;
                            break;
                        }
                    }
                }
                if (add){
                    int size = lists.size();
                    lens[size] = len;
                    sums[size] = sum;
                    xors[size] = xor;
                    lists.add(size, new ArrayList<>(Arrays.asList(strs[i])));
                }


            }
        }
        return lists;


    }
    public List<List<String>> groupAnagrams2(String[] strs) {
        //length-sum- ^


        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
           
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
           String key=String.valueOf( chars);
           if (map.containsKey(key)){
               map.get(key).add(strs[i]);
           }else{
               map.put(key,new ArrayList<>(Arrays.asList( strs[i])));
           }
        }
        return  new  ArrayList<List<String>>(  map.values());


    }
}
