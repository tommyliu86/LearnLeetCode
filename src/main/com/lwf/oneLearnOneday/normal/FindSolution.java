package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSolution {
    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     * class CustomFunction {
     *     // Returns f(x, y) for any given positive integers x and y.
     *     // Note that f(x, y) is increasing with respect to both x and y.
     *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     *     public int f(int x, int y);
     * };
     */

    /**
     * f()跟随x，y单调递增，因此我们可以使用二分查找来进行遍历查找，我们让x从小到大，y从大到小的双指针查找数对即可。
     */
    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> ans=new ArrayList<>();
            int x=1,y=half(customfunction,z);
            while (y>0&&x<1001){
                int cur = customfunction.f(x, y);
                if (cur>z){
                    y--;
                }else if (cur==z){
                    ans.add(new ArrayList<>(Arrays.asList(x,y )));
                    x++;
                }else{
                    x++;
                }
            }
            return ans;
        }
        public int half(CustomFunction customFunction,int z){
            int l=1,r=1000;
            while (l<=r){
                int m=(l+r)/2;
                int cur = customFunction.f(1, m);
                if (cur==z){
                    return m;
                }else if (cur>z){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }
            return l;
        }

    }

    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y);
    }
}
