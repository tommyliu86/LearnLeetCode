package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/11/4 8:49
 */
public class ReachNumber {

    class Solution {
        public int reachNumber(int target) {
            target=Math.abs(target);
            int i=0;
            int sum=0;
            while (sum<target){
                i++;
                sum+=i;
            }
            if (sum==target){
                return i;
            }
            //sum>target
            /**
             * 考虑 sub是差值，为了消除这个差值，需要从 1~i中找到 几个数：sum=sub/2，这时，他们变为负号，2*sum=sub
             * 这里需要考虑sub的奇偶性，偶数则可以直接计算，但是奇数
             */
            int sub = sum - target;
            return sub%2==0?i:i+1+i%2;
        }
    }

    /**
     * 乘阶需要是long型，因此这样不行。因为是累加的，因此直接用加法循环就可以找到最小大于的数，不需要二分法
     */
    class Solution1 {
        public int reachNumber(int target) {
            target = Math.abs(target);
            int half = half(target, 1, target);
            int step = getStep(half);
            if (step == target) {
                return half;
            }
            int i = step - target;
            return i % 2 == 0 ? half : half + 1 + half % 2;
        }


        public int half(int target, int l, int r) {
            if (l >= r) {
                return l;
            }
            int half = (l + r) / 2;
            int step = getStep(half);
            if (step == target) {
                return half;
            } else if (step > target) {
                return half(target, l, half);
            } else {
                return half(target, half + 1, r);
            }
        }

        public int getStep(int i) {
            return ((1 + i) * i) / 2;
        }

    }
}
