package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
 * 1606. 找到处理最多请求的服务器
 * @author: liuwenfei14
 * @date: 2022-03-30 09:04
 */
public class BusiestServers {
    public static void main(String[] args) {
        new Solution().busiestServers(2, new int[]{2, 3, 4, 8}, new int[]{3, 2, 4, 3});

        PriorityQueue<int []> workQueue=new PriorityQueue<int[]>(Comparator.comparing(a->a[1]));
        workQueue.add(new int[]{0,0});
        workQueue.add(new int[]{1,1});
        workQueue.add(new int[]{2,2});
        System.out.println(workQueue);
    }

    static class test {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            int[] serverCount=new int[k];

            SortedSet<Integer> freeSet=new TreeSet<>();
            for (int i = 0; i < k; i++) {
                freeSet.add(i);
            }
            PriorityQueue<int []> workQueue=new PriorityQueue<int[]>((a,b)->a[1]-b[1]);


            for (int i = 0; i < arrival.length; i++) {


                while (!workQueue.isEmpty()&& workQueue.peek()[1]<=arrival[i]){
                    int[] poll = workQueue.poll();
                    freeSet.add(poll[0]);
                }
                if (freeSet.isEmpty()){
                    continue;
                }

                int curIndex = i % k;
                Integer ceiling = ((TreeSet<Integer>) freeSet).ceiling(curIndex);
                if (ceiling==null){
                    ceiling=freeSet.first();
                }
                workQueue.add(new int[]{ceiling,arrival[i]+load[i]});
                freeSet.remove(ceiling);
                serverCount[ceiling]=serverCount[ceiling]+1;

            }
            int max = Arrays.stream(serverCount).max().getAsInt();
            List<Integer> maxIndex = new ArrayList<>();
            for (int i = 0; i < serverCount.length; i++) {

                if (max == serverCount[i]) {
                    maxIndex.add(i);
                }
            }
            return maxIndex;
        }
        class node{
            int index;
            int count;
            node pre;
            node post;
            node(){}
            void add(node node){

            }
        }
    }

    /**
     * 使用数组模拟，对服务器数组在查找空闲时使用while循环找一圈的方法，超出时间限制。。
     */
    static class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            int[] serverTime = new int[k];
            int[] serverCount = new int[k];
            int max = 0;
            List<Integer> maxIndex = new ArrayList<>();
            for (int i = 0; i < arrival.length; i++) {

                int curIndex = i % k;
                boolean abort = false;
                while (!abort && serverTime[curIndex] > arrival[i]) {
                    curIndex++;
                    if (curIndex > k - 1) {
                        curIndex -= k;
                    }
                    if (curIndex == i % k) {
                        abort = true;
                        continue;
                    }
                }
                if (!abort) {
                    serverTime[curIndex] = arrival[i] + load[i];
                    serverCount[curIndex] = serverCount[curIndex] + 1;
                    if (max == serverCount[curIndex]) {
                        maxIndex.add(curIndex);
                    } else if (max < serverCount[curIndex]) {
                        max = serverCount[curIndex];
                        maxIndex.clear();
                        maxIndex.add(curIndex);
                    }
                }
            }
            return maxIndex;

        }
    }
}
