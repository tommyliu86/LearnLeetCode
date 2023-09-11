package com.lwf.oneLearnOneday.hard;

import com.lwf.learn.everyday.half.PeakIndexInMountainArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liuwenfei
 * @date 2023/9/11 8:40
 */
public class ScheduleCourse {
    /**
     * 贪心思路，首先考虑到需要使用每个课程的结束时间作为限制，然后从前向后遍历课程，同时统计在每个结束时间内可以学多少课程
     * 然后使用贪心思路，如果当前课程+ f(i-1) 超时，考虑是否可替换
     *
     * 思路：需要注意，在推广到任意的 s[i−1]s[i - 1]s[i−1] 和 s[i]s[i]s[i] 时，还需要证明在已知 s[i−1]s[i - 1]s[i−1] 时，多考虑一个 courses[i]courses[i]courses[i] 不会出现 s[i]s[i]s[i] 的和 s[i−1]s[i - 1]s[i−1] 的长度差超过 111 的情况。 这个基于已得证的第 111 点，再用反证法可证：如果在 s[i−1]s[i - 1]s[i−1] 的基础上多考虑一个 courses[i]courses[i]courses[i] 能够使得总长度增加超过 111，说明存在一个「之前没有被选的课程」+「课程 courses[i]courses[i]courses[i]」的持续时间比「被替换的课程」短。 那么使用这个「之前没有被选的课程」直接替换「被替换的课程」可得到长度与 s[i−1]s[i - 1]s[i−1] 相同，且总耗时更短的排列方案，这与 s[i−1]s[i - 1]s[i−1] 本身是最优排列冲突。
     *
     * 作者：宫水三叶
     * 链接：https://leetcode.cn/problems/course-schedule-iii/solutions/1156693/gong-shui-san-xie-jing-dian-tan-xin-yun-ghii2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 使用comparator 50ms
     */
    class Solution {
        public int scheduleCourse(int[][] courses) {

            int times=0;
            Arrays.sort(courses, (a,b)->Integer.compare(a[1],b[1]));
            PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->Integer.compare(b,a));

            for (int i = 0; i < courses.length; i++) {
                int[] cur = courses[i];
                //上课时间超过限制时间
                if (times+cur[0]>cur[1]){
                    if (queue.isEmpty()||queue.peek()<=cur[0]){
                        continue;
                    }else{ //这里只需要移除最大耗时的课程
                        times-= queue.poll();
                        queue.add(cur[0]);
                        times+=cur[0];
                    }
                }else{ //上课时间没有超过限制
                    queue.add(cur[0]);
                    times+=cur[0];
                }
            }
            return queue.size();
        }
    }
}
