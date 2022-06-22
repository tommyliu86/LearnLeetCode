package com.lwf.learn.everyday.data.level2;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 16:13
 */
public class CanVisitAllRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int[] gets=new int[rooms.size()];
            gets[0]=1;
            recursive(rooms,0,gets);
            for (int i = 0; i < gets.length; i++) {
                if (gets[i]==0){
                    return false;
                }
            }
            return true;
        }
        public void recursive(List<List<Integer>> rooms, int room,int[] gets){
            List<Integer> keys = rooms.get(room);
            for (int i = 0; i < keys.size(); i++) {
                Integer key = keys.get(i);
                if (gets[key]>0){
                    continue;
                }
                gets[key]++;
                recursive(rooms,key,gets);
            }
        }
    }
}
