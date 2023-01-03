package com.lwf.oneLearnOneday.normal;

import com.lwf.oneLearnOneday.easy.OrderedStream;
import sun.nio.ch.SelChImpl;

import java.util.PriorityQueue;

public class GetNumberOfBacklogOrders {

    class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<int[]> sells=new PriorityQueue<int[]>((a,b)-> Integer.compare(a[0],b[0]));
            PriorityQueue<int[]> buyers=new PriorityQueue<int[]>((a,b)->Integer.compare(b[0],a[0]));
            Long sellcount=0L;
            Long buycount=0l;
            for (int i = 0; i < orders.length; i++) {
                int[] order = orders[i];
                if (order[2]==0){
                    while (order[1]>0&& sells.size()>0&&  sells.peek()[0]<=order[0]){
                        int[] poll = sells.poll();

                        order[1]-=poll[1];
                        if ( order[1]<0){
                            sellcount -=(order[1]+poll[1]);
                            poll[1]-=(order[1]+poll[1]);
                            sells.offer(poll);
                            break;
                        }else{
                            sellcount-=poll[1];
                        }

                    }
                    if (order[1]>0) {
                        buyers.offer(order);
                        buycount+=order[1];
                    }
                }else{
                    while (order[1]>0&& buyers.size()>0&&  buyers.peek()[0]>=order[0]){
                        int[] poll = buyers.poll();
                        order[1]-=poll[1];
                        if ( order[1]<0){
                            buycount -=(order[1]+poll[1]);
                            poll[1]-=(order[1]+poll[1]);
                            buyers.offer(poll);
                            break;
                        }else{
                            buycount-=poll[1];
                        }

                    }
                    if (order[1]>0) {
                        sells.offer(order);
                        sellcount+=order[1];
                    }
                }
            }
            return (int) ((sellcount+buycount)%1000000007);
        }

    }
}
