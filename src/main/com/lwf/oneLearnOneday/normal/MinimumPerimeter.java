package com.lwf.oneLearnOneday.normal;

import com.lwf.oneLearnOneday.easy.CalculateTax;

/**
 * 1954. 收集足够苹果的最小花园周长
 *
 * @author liuwenfei
 * @date 2023/12/25 9:32
 */
public class MinimumPerimeter {
    /**
     * 数学计算，通过矩阵，找出变化的规律，可以把整体分成4份，每份的变化完全相同。因此我们可以通过直接计算找到变化
     */
    class Solution {
        public long minimumPerimeter(long neededApples) {
            long i = 0;

            while (i < Integer.MAX_VALUE) {
                if (2 * i * (i + 1) * (2 * i + 1) >= neededApples) {
                    break;
                }
                i++;
            }
            return 8 * i;
        }

    }
    public static void main(String[] args) {
        System.out.println(Double.valueOf(1000d).longValue());
        System.out.println(Math.pow(4, 0.5));
        System.out.println(calc(1000000000L));
    }
    public static long calc(long i){
        return (long) 2 * i * (i + 1) * (2 * i + 1);
    }
    /**
     * 在有数学计算公式的基础上，可以通过二分查找，快速找到第一个大于等于need的边长
     */
    class Solution1 {

        public long minimumPerimeter(long neededApples) {

            long i=1,j= Double.valueOf( Math.pow(neededApples,0.5)).longValue();
            while (i<j){
                long mid=i+(j-i)/2;
                long calc = calc(mid);
                if (calc<neededApples){
                    i=mid+1;
                }else if (calc==neededApples){
                    return 8*i;
                }else{
                    j=mid;
                }
            }
            return 8*i;
        }
        public  long calc(long i){
            return (long) 2 * i * (i + 1) * (2 * i + 1);
        }
    }

}
