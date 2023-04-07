package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/4/6 9:00
 */
public class BaseNeg2 {
    public static void main(String[] args) {
        new Solution().baseNeg2(7);
    }

    static
    class Solution {
        public String baseNeg2(int n) {
            if (n==0) return "0";
            int[] bits=new int[32];
            int i=0;
            while (n!=0){
                int cur=n&1;
                bits[i]+=cur;
                if (cur==1&&(i&1)==1){
                    bits[i+1]++;
                }
                n>>>=1;
                i++;
            }
            int step=0;
            //step表示的是在这个位置放一个1之后，剩余了多少数要给到i+1，因此是/-2，因为相邻两个数是反向符号关系
            for (int j = 0; j < bits.length; j++) {
               int cur= (bits[j]+step);
               bits[j]=cur&1;
               step=  (cur-bits[j])/-2;
            }
            StringBuilder stringBuilder = new StringBuilder();

            for (int j = bits.length-1; j >= 0; j--) {
                if (stringBuilder.length()==0&&bits[j]==0){
                    continue;
                }
                stringBuilder.append(bits[j]);
            }
            return stringBuilder.toString();
        }
    }
    static
    class Solution1 {
        public String baseNeg2(int n) {
            if (n==0) return "0";
            int ans = 0;
            int i = 0;
            while (n != 0) {
                int cur = n & 1;
                ans+= cur<<i;
                //通过改变原来的n的大小，假如当前位置是奇数并且有位数，则ans此处为-1，那么我们的答案中应该是i+1 +i 两位有值，
                //但是i+1有值时是多出来了一位，我们设置到ans中多一个i+1出来，等同于n多加一个当前位，让n变多之后，在后续仍然会计算到
                //ans中，这样避免了对ans的判断！非常巧妙的思路，不去操作ans，而是通过操作n来获取最后的结果，相当于把计算延后，
                if (cur==1&&(i&1)==1){
                    n++;
                }
                n >>>= 1;

                i++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (ans != 0) {
                stringBuilder.append(ans & 1);
                ans >>>= 1;
            }
            return stringBuilder.reverse().toString();
        }
    }
}
