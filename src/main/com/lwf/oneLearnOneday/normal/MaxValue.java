package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/1/4 9:20
 */
public class MaxValue {
    /**
     * int类型越界。。
     */
    class Solution {
        public int maxValue(int n, int index, int maxSum) {

            int left=index+1;
            int right=n-index;
            int min=1;
            int max=maxSum;
            while (min<=max){
                int mid=max-(max-min)/2;
                long sum = sum(left, right, mid);
                if (sum >maxSum){
                    max=mid-1;
                }else{
                    min=mid+1;
                }
            }
            return max;
        }
        public long sum(int l,int r,int i){
            return subSum(l,i)+subSum(r,i)-i;
        }
        public  long subSum(int l,int i){
            if (i<=l){
                return (long)(l-i)+( (long)(1 + i) * i / 2);
            }else{
                return  (((long)i+(long)(i-l+1))*l/2);
            }
        }
    }
}
