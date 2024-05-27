package com.lwf.oneLearnOneday.normal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 *
 * @author: liuwenfei
 * @date: 2024/5/22-8:42
 */
public class FindWinners {
    class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {

            int[] scores = new int[100_001];
            Arrays.fill(scores, -1);
            for (int[] m : matches) {
                status(scores,m[0],true);
                status(scores,m[1],false);
            }
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>());
            ans.add(new ArrayList<>());
            for (int i = 0; i < scores.length; i++) {
                if (scores[i]==0) {
                    ans.get(0).add(i);
                }else if (scores[i]==1){
                    ans.get(1).add(i);
                }
            }
            return ans;
        }
        public void status(int[] s,int i,boolean win){
            if (s[i]==-1) {
                s[i]=win?0:1;
            }else if (s[i]==0){
                s[i]=win?0:1;
            }else{
                s[i]=win?s[i]:(s[i]+1);
            }
        }
    }
}
