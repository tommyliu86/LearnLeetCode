package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/2/23 9:18
 */
public class GrayCode2 {
    /**
     * 格雷编码的变化，只是多了一个开始位的限制，其他都不变。。
     */
    class Solution {
        //先获取gray，再全部异或start
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> ans=new ArrayList<>();
            ans.add(0^start);
            while (ans.size()<1<<n){
                int l = ans.size();
                for (int i = l-1; i >= 0; i--) {
                   ans.add( ans.get(i)^(l));
                }
            }
            return ans;
        }

    }
}
