package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 6. Z 字形变换
 * @author: liuwenfei14
 * @date: 2022-03-01 19:39
 */
public class ConvertZ {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }
        char[] chars = s.toCharArray();
        List<List< Character>> lists=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {

            lists.add(i,new ArrayList<Character>());
        }
        int listIndex=0;
        int index=1;
        for (int i = 0; i < chars.length; i++) {
            if (listIndex==0){
                index=1;
            }
            if (listIndex==numRows-1){
                index=-1;
            }
            lists.get(listIndex).add(chars[i]);
            listIndex=listIndex+index;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            for (Character character : lists.get(i)) {
                stringBuilder.append(character);
            }


        }
        return stringBuilder.toString();
    }
}
