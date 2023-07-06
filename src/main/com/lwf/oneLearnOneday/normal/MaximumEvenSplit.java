package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/7/6 8:30
 */
public class MaximumEvenSplit {
    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> ans=new ArrayList<>();
            if (finalSum%2==1){
                return ans;
            }
            long i=2;
            while (i<=finalSum){
                ans.add(i);
                finalSum-=i;
                i+=2;
            }
            if (finalSum>0){
                Long remove = ans.remove(ans.size() - 1);
                remove+=finalSum;
                ans.add(remove);
            }
            return ans;
        }
    }
}
