package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 1276. 不浪费原料的汉堡制作方案
 *
 * @author liuwenfei
 * @date 2023/12/25 9:18
 */
public class NumOfBurgers {
    /**
     * 遍历，枚举所有的组合
     * 也可以用第二种，直接数学计算解方程，找到所有的边界条件进行计算
     */
    class Solution1 {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            int big = 0;
            boolean find = false;
            while (big <= cheeseSlices && big * 4 <= tomatoSlices) {
                if ((big * 4 + (cheeseSlices - big) * 2) == tomatoSlices) {
                    find = true;
                    break;
                }
                big++;
            }
            List<Integer> ans = new ArrayList<>();
            if (find) {
                ans.add(big);
                ans.add(cheeseSlices - big);
            }
            return ans;
        }
    }

    /**
     * 直接数学计算解方程，找到所有的边界条件进行计算
     */
    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            List<Integer> ans=new ArrayList<>();
            if (tomatoSlices%2!=0||tomatoSlices<cheeseSlices*2||tomatoSlices>cheeseSlices*4){
                return  ans;
            }
            //直接计算
            ans.add(tomatoSlices/2-cheeseSlices);
            ans.add(cheeseSlices*2-tomatoSlices/2);
            return ans;
        }
    }
}
