package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 14:48
 */
public class SeatManager {
    int [] list;
    int use=0;

    public SeatManager(int n) {
        list=new int[n];
    }

    public int reserve() {
        int i=use+1;
        list[use]=1;
        while (use<list.length&&list[use]==1){
            use++;
        }
        return i;
    }

    public void unreserve(int seatNumber) {
        int i = seatNumber - 1;
        list[i]=0;

        use=Math.min( i,use);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
