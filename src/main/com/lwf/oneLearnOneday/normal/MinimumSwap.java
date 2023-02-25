package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/2/25 9:28
 */
public class MinimumSwap {
    /**
     *  规律总结法：记录一个字符串中x和y不相同的个数，一次遍历获取到，xx和yy不同正好可以使用一次交换让其相同，因此交换最小的次数通过x和y自己交换来
     * 计数，如果剩余x和y都==1时，交换两次，
     */
    class Solution {
        public int minimumSwap(String s1, String s2) {
            int x=0;
            int y=0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i)!=s2.charAt(i)) {
                    if (s1.charAt(i)=='x') {
                        x++;
                    }else{
                        y++;
                    }
                }
            }
            if (x==0&&y==0) return 0;
            int ans=0;
            ans+=x/2+y/2;
            x%=2;
            y%=2;
            if (x!=y){
                return -1;
            }
            if (x==1&&y==1){
                ans+=2;
            }
            return ans;
        }
    }
}
