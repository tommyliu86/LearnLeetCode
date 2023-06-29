package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/6/29 8:21
 */
public class ReconstructMatrix {
    /**
     * 并没有快多少。。。
     */
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<List<Integer>> ans=new ArrayList<>();
            int sum=0,two=0;
            for (int i = 0; i < colsum.length; i++) {
                sum+=colsum[i];
                two+=(colsum[i]==2?1:0);
            }
            if (upper+lower!=sum||(upper-=two)<0||(lower-=two)<0){
                return ans;
            }

            for (int i = 0; i < 2; i++) {
                ans.add(new ArrayList<>());
            }
            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i] == 2) {
                    ans.get(0).add(1);
                    ans.get(1).add(1);
                }else if (colsum[i] == 1) {
                    if (upper==0){
                        ans.get(1).add(1);
                        lower--;
                        ans.get(0).add(0);
                    }else{
                        ans.get(0).add(1);
                        upper--;
                        ans.get(1).add(0);
                    }
                }else{
                    ans.get(0).add(0);
                    ans.get(1).add(0);
                }
            }


            return ans;
        }
    }
    /**
     * 两次遍历+fill，
     */
    class Solution1 {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            List<List<Integer>> ans=new ArrayList<>();
            if (upper+lower!= Arrays.stream(colsum).sum()) {
             return ans;
            }
            int[] l1=new int[colsum.length];
            int[] l2=new int[colsum.length];

            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i] == 2) {
                    if (upper==0||lower==0){
                        return ans;
                    }
                    l1[i] = 1;
                    l2[i] = 1;
                    upper--;
                    lower--;
                }
            }
            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i] == 1) {
                    if (upper==0){
                        l2[i] = 1;
                        lower--;
                    }else{
                        l1[i] = 1;
                        upper--;
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                ans.add(new ArrayList<>());
            }

            for (int i = 0; i < l1.length; i++) {
               ans.get(0).add(l1[i]);
               ans.get(1).add(l2[i]);
            }
            return ans;
        }
    }
}
