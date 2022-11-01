package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/10/31 10:46
 */
public class MagicalString {
    /**
     * 双指针，一个记录下一组的个数，一个记录数组的下标，根据每次组中是1还是2可以知道下一个组是1还是2，因此可以一次遍历
     */
    class Solution {
        public int magicalString(int n) {
            if (n<4){
                return 1;
            }
            int[] s=new int[n];
            s[0]=1;
            s[1]=2;
            s[2]=2;

            int i=1;
            int j=2;
            int count=1;

            while (j<n-1){
                int nextNum=s[j]==1?2:1;
                int nextCount=s[++i];
                for (int k = 0;j<n-1&& k < nextCount; k++) {
                    s[++j]=nextNum;
                    if (nextNum==1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
