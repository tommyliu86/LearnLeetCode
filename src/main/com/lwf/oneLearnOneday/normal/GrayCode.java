package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 * @author liuwenfei
 * @date 2023/2/23 9:53
 */
public class GrayCode {
    /**
     * 归纳法，推导出规律来进行迭代
     * 1.由题目可知，长度是2的倍数
     * 2.假设我们有一个 i<n的f(i)的答案，那么可以知道，其中的所有数字都是小于2（i）的排列好的，那么f（i+1）如何求解？f(i+1)正好是f(i)
     * 长度的2倍，因此我们可以考虑从f(i)->f(i+1)是否可行，可以知道这时候的多出来的数字是哪些？是比f（i）中在第i+1位上多了一个二进制1，由此
     * 我们可以把f(i)的所有数字反过来，在最高位+1来获取下一个排列！
     */
    class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ans=new ArrayList<>();
            ans.add(0);
            while (ans.size()<1<<n){
                int i = ans.size();
                for (int j = i-1; j >= 0; j--) {
                    ans.add(ans.get(j)^i);
                }
            }
            return ans;
        }
    }
    /**
     * 暴力方法，回溯大法,对每一位都进行回溯检查
     */
    class Solution1 {
        int l;
        public List<Integer> grayCode(int n) {
            l=n;
            List<Integer> ret = new ArrayList<Integer>();
            ret.add(0);
            boolean[] mark=new boolean[1<<l];
            mark[0]=true;
            dfs(ret, mark);
            return ret;
        }
        public boolean dfs(List<Integer> ret,boolean[] mark){
            if (ret.size()==1<<l){
                return Integer.bitCount( ret.get(ret.size()-1))==1;
            }

            Integer cur = ret.get(ret.size() - 1);
            for (int i = 1; i <= l; i++) {
                int next = cur ^ (1 << i-1);
                if (!mark[next]){
                    mark[next]=true;
                    ret.add(next);
                    boolean dfs = dfs(ret, mark);
                    if (dfs){
                        return true;
                    }else{
                        mark[next]=false;
                        ret.remove(ret.size()-1);
                    }
                }
            }
            return false;

        }
    }
}
