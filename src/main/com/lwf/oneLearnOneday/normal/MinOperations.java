package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2022/12/2 9:07
 */
public class MinOperations {
    /**
     * 计数，可以通过左右侧的‘1’的个数直接计算位移
     */
    class Solution {
        public int[] minOperations(String boxes) {
            int[] ans=new int[boxes.length()];
            //left 和right计算时要包括当前位置的数值到left中，这样在循环计算时直接使用left和right，因为从 i-》i+1，右侧的这个数也是计算在right计数中的
            int left=boxes.charAt(0)=='0'?0:1;int right=0;
            for (int i = 1; i < boxes.length(); i++) {
                if (boxes.charAt(i)=='1') {
                    right+= 1;
                    ans[0]+=i;//计算初始
                }
            }

            for (int i = 1; i < ans.length; i++) {
                ans[i]=ans[i-1]+left-right;
               if (boxes.charAt(i)=='1'){
                   left++;
                    right--;
               }
            }
            return ans;
        }
    }
    class Solution1 {
        public int[] minOperations(String boxes) {
            int[] ans=new int[boxes.length()];
            List<Integer> indexes=new ArrayList<>();
            for (int i = 0; i < boxes.length(); i++) {
                if (boxes.charAt(i)=='1') {
                    indexes.add(i);
                }
            }
            for (int i = 0; i < ans.length; i++) {
                for (Integer index : indexes) {
                    ans[i]+=Math.abs(index-i);
                }
            }
            return ans;
        }
    }
}
