package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/5/22 9:35
 */
public class StoreWater {
    class Solution {
        public int storeWater(int[] bucket, int[] vat) {
            int max = Arrays.stream(vat).max().getAsInt();
            if (max == 0) return 0;
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= max && i < ans; i++) {
                int k = i;
                for (int j = 0; j < vat.length; j++) {
                    k += Math.max(0, vat[j] / i - bucket[j] + ((vat[j] % i) == 0 ? 0 : 1));
                }
                ans = Math.min(ans, k);
            }
            return ans;
        }
    }

    class Solution1 {
        public int storeWater(int[] bucket, int[] vat) {

            Integer[] indez = new Integer[bucket.length];
            for (int i = 0; i < indez.length; i++) {
                indez[i] = i;
            }
            //排序后，用次数少的在前面，因此我们每次取最前面的这个的次数作为使用次数，则总次数==t+i~n
            Arrays.sort(indez, Comparator.comparingInt(a -> bucket[a] == 0 ? (vat[a]+1) : ((vat[a]+bucket[a]-1) / bucket[a])));

            int ans = Integer.MAX_VALUE;

            for (int i = 0; i < indez.length; i++) {
                Integer cur = indez[i];
                if (vat[cur]==0)continue;
                int t=bucket[cur]==0?(vat[cur]+1):((vat[cur]+bucket[cur]-1)/bucket[cur]);
                if (t>ans) break;
                int k=t;
                for (int j = i+1; j < indez.length; j++) {
                    Integer ii = indez[j];
                    k+=Math.max(0, (vat[ii]+t-1)/t -bucket[ii]);
                }
                ans=Math.min(k,ans);
            }

            return ans==Integer.MAX_VALUE?0:ans;
        }
    }
}
