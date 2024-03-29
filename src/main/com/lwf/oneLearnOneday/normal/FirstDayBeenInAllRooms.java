package com.lwf.oneLearnOneday.normal;

/**
 * 1997. 访问完所有房间的第一天
 *
 * @author: liuwenfei
 * @date: 2024/3/29-8:50
 */
public class FirstDayBeenInAllRooms {
    /**
     * 设访问i时，第一次（奇数次），会后退到next，偶数次才能向前，
     * f0(i)表示第一次访问,f1(i)表示偶数次访问  则f0（i)=f1（i）+1，也就是每个下一个位置是前面一个位置的偶数次访问，
     * 那么我们可以记录每一个位置的偶数次访问需要的次数，那么 我们需要找到的就是f（i）的天数
     * f（i）=sum（f（next）+。。。+f（i-1））+2
     */
    class Solution {
        static int mod=1000_000_007;
        public int firstDayBeenInAllRooms(int[] nextVisit) {
            int n = nextVisit.length;
            //每个节点从奇数走一轮回来的天数
            int[] next = new int[n];
            next[0]=1;
            //利用前缀和进行计算
            long[] sum = new long[n + 1];
            sum[1]=1;
            for (int i = 0; i < next.length - 1; i++) {
                int back = nextVisit[i];

                next[i]=(int) (sum[i]- sum[back]+2+mod)%mod;

                sum[i+1]=(sum[i]+next[i])%mod;
            }
            return (int) sum[n-1];
        }
    }
}
