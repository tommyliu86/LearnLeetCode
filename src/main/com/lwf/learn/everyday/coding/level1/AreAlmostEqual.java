package com.lwf.learn.everyday.coding.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 15:17
 */
public class AreAlmostEqual {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length()!=s2.length()){
                return false;
            }
            char[] char1 = s1.toCharArray();
            char[] char2 = s2.toCharArray();
            int dis=0;
            List<Integer> list=new ArrayList<>();
            for (int i = 0; dis<3&&i < char1.length; i++) {
                if (char1[i]!=char2[i]){
                    dis++;
                    list.add(i);
                }
            }
            if (dis==0){
                return true;
            }else if (dis==2){
                Integer i1 = list.get(0);
                Integer i2 = list.get(1);
                return char1[i1]==char2[i2]&&char1[i2]==char2[i1];
            }else{
                return false;
            }
        }
    }
}
