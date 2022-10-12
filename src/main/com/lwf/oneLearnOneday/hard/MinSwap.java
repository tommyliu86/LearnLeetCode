package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2022/10/10 8:59
 */
public class MinSwap {
    /**
     * dp状态转移方程：a 不交换 b交换 ,多个条件的分步使用，可以非常方便的实现多个条件组合，而不用写if else

     */
    class Solution {
        public int minSwap(int[] nums1, int[] nums2) {
            int l = nums1.length;
            int[] changes=new int[l];
            changes[0]=1;
            int[] noChanges=new int[l];
            for (int i = 1; i < nums1.length; i++) {
                //设置初始值，表示没法交换
                changes[i]=l;
                noChanges[i]=l;
                //不用交换 成立,则保持 a-》a-1 ，b-》b-1的队列，因此没交换就对应使用上一个元素没交换，交换了则对应上一个元素的交换
                if (nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                    noChanges[i]=Math.min(noChanges[i],noChanges[i-1]);
                    changes[i]=Math.min(changes[i],changes[i-1]+1);
                }
                if (nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                    noChanges[i]=Math.min(noChanges[i],changes[i-1]);
                    changes[i]=Math.min(changes[i],noChanges[i-1]+1);
                }
            }
            return Math.min(noChanges[l-1],changes[l-1]);
        }
    }
    /**
     * dp状态转移方程：a 不交换 b交换 ,多个条件的分步使用，可以非常方便的实现多个条件组合，而不用写if else
     *
     * 1.a》a-1 && b>b-1 a=（a-1），b=(b-1）  +1
     * 2.a>b-1 && b>a-1 a=b-1，b=(a-1) +1
     */
    class Solution1 {
        public int minSwap(int[] nums1, int[] nums2) {
            int changeFalse=0;
            int changeTrue=1;
            int l=nums1.length;
            for (int i = 1; i < nums1.length; i++) {
                int of=changeFalse;
                int ot=changeTrue;
                changeFalse=l;
                changeTrue=l;
                if (nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]) {
                    changeFalse=Math.min(changeFalse,of);
                    changeTrue=Math.min(changeTrue,ot+1);
                }
                if (nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                    changeFalse=Math.min(changeFalse,ot);
                    changeTrue=Math.min(changeTrue,of+1);
                }
            }
            return Math.min(changeFalse,changeTrue);
        }
    }
}
