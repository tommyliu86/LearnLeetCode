package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/10/12 9:24
 */
public class TopStudents {
    /**
     * hash 进行string的查找获取得分，排序后返回即可
     */
    class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            Map<String ,Integer> scores=new HashMap<>();
            for (String s : positive_feedback) {
                scores.put(s,3);
            }
            for (String s : negative_feedback) {
                scores.put(s,-1);
            }
            int[][] sids=new int[student_id.length][2];
            for (int i = 0; i < sids.length; i++) {
                sids[i][0]=student_id[i];
                sids[i][1]=getScores(scores,report[i]);
            }
            Arrays.sort(sids, (a,b)->{
                if (a[1]==b[1]){
                    return Integer.compare(a[0],b[0]);
                }else{
                    return Integer.compare(b[1],a[1]);
                }
            });
            List<Integer> ans=new ArrayList<>();
            for (int i = 0; i < k; i++) {
                ans.add(sids[i][0]);
            }
            return ans;
        }

        private int getScores(Map<String, Integer> scores, String s) {
            int ans=0;
            for (String s1 : s.split(" ")) {
                ans+=scores.getOrDefault(s1,0);
            }
            return ans;

        }
    }
}
