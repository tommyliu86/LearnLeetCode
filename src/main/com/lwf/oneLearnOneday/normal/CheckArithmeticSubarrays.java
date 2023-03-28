package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/3/23 9:05
 */
public class CheckArithmeticSubarrays {
    public static void main(String[] args) {
        new Solution().checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},
                new int[]{0,0,2},
        new int[]{2,3,5});
    }
    /**
     * 优化，通过等差数列的特性，通过一次遍历找到最大最小值，计算出等差的差，然后一次遍历，来找每一位是否满足差，同时记录差值大小，最后统计看是否是满足下标递增即可
     */
    static
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> ans=new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                int left=l[i];
                int right=r[i];
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for (int j = left; j <right+1; j++) {
                    min=Math.min(min,nums[j]);
                    max=Math.max( max,nums[j]);
                }
                if ((max-min)%(right-left)!=0){
                    ans.add(false);
                    continue;
                }
                if (max-min==0){
                    ans.add(true);
                    continue;
                }
                int mid=(max-min)/(right-left);
                boolean[] index=new boolean[right+1-left];
                boolean isOk=true;
                for (int j = left; j <right+1; j++) {
                    if ((nums[j]-min)%mid==0) {
                        index[(nums[j]-min)/mid]=true;
                    }else{
                        isOk=false;
                        break;
                    }
                }

                for (int j = 0; j < index.length; j++) {
                    if (index[j]==false) {
                        isOk=false;
                        break;
                    }
                }
                ans.add(isOk);

            }
            return ans;
        }
    }
    /**
     * 长度为500，因此可以直接暴力解题
     */
    class Solution1 {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> ans=new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                int left=l[i];
                int right=r[i];
                int[] ints = Arrays.copyOfRange(nums, left, right + 1);
                Arrays.sort(ints);
                if (isSub(ints)){
                    ans.add(true);
                }else{
                    ans.add(false);
                }

            }
            return ans;
        }

        private boolean isSub(int[] ints) {
            int sub=ints[1]-ints[0];
            for (int i = 2; i < ints.length; i++) {
                if (sub!=ints[i]-ints[i-1]) return false;
            }
            return true;

        }
    }
}
