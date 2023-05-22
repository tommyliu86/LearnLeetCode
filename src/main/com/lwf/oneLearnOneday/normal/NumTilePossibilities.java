package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author liuwenfei
 * @date 2023/5/19 8:49
 */
public class NumTilePossibilities {
    /**
     * 1.子问题思路：假设 有str,我们选中第一个位置放 a，则剩余 str-a，str-a 的所有非空组合的长度(1~l-1），我们再把第一个位置的所有
     * 不同字母情况都考虑到，这样就获取到了所有组合。因此这时的问题变为了找 str-a的序列，F(n)=count +F(n-1),count=长度n中的不同字母种类
     */
    class Solution {
        public int numTilePossibilities(String tiles) {
            char[] chars = tiles.toCharArray();
            int[] count = new int[26];
            for (int i = 0; i < chars.length; i++) {
                count[chars[i] - 'A']++;
            }
            int counts = 0;

            return dfs(count);

        }
        //每一次dfs表示的是要取值的下一个位置，这个位置可以的取值可以有 当前还有多少种字母决定，每个字母固定之后，后续的剩余字母可以排列
        //的种类 需要再dfs去计算，因此变成了一个 递归模式，求每个组合的可能性。
        //dfs返回的是 剩余字母可以组合的所有的非空排列，因此其字符串长度从 1~k，当前位固定为某个字母时，加上后续的就变为了2~k+1，因此该位
        //上取值，需要+1;
        public int dfs(int[] count){
            int ans=0;
            for (int i = 0; i < count.length; i++) {
                if (count[i]>0){
                    ans++;
                    count[i]--;
                    ans+=dfs(count);
                    count[i]++;
                }
            }
            return ans;
        }
    }
}
