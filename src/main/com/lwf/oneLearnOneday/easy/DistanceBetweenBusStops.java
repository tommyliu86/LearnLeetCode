package com.lwf.oneLearnOneday.easy;

public class DistanceBetweenBusStops {
    class Solution {
        public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            int total=0;
            int[] sum=new int[distance.length+1];
            for (int i = 0; i < distance.length; i++) {
                sum[i+1]=sum[i]+distance[i];
            }
            total=sum[distance.length];
            if (destination<start){
                int tem=start;
                start=destination;
                destination=tem;
            }


            int dis=sum[destination]-sum[start];
            return Math.min(total-dis,dis);
        }
    }
}
