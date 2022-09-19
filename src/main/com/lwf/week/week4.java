package com.lwf.week;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/17 22:18
 */
public class week4 {

    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int[] rtn=new int [nums.length];
            int[]  mark=new int [32];//最小下标
            int max=0;
            for (int i = nums.length - 1; i >= 0; i--) {
                int num = nums[i];
                int j=0;
                while (num!=0){
                    if ((num&1)==1) {
                        mark[j]=i;
                    }
                    num>>=1;
                    j++;
                }
                int max1 = max(mark);
                rtn[i]=(max1==0?i:max1)-i+1;
            }
            return rtn;
        }
        private int max(int[] mark){
           int rtn=0;
            for (int i = 0; i < mark.length; i++) {
                rtn= Math.max(rtn,mark[i]);
            }
            return rtn;
        }

    }
    class Solution3 {
        public int[] smallestSubarrays(int[] nums) {
            int[] rtn=new int [nums.length];

            int max=0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i==nums.length-1){
                    rtn[i]=1;
                    max=nums[i];
                }else{
                    if (nums[i]<max){
                        int n=nums[i];
                        int curl=1;
                        for (int j = i+1;n<max&& j <i+1+ rtn[i+1]; j++) {
                            n|=nums[j];
                            curl++;
                        }
                        rtn[i]=curl;
                        max=n;


                    }else if (nums[i]==max){
                        rtn[i]=1;
                    }else{ //nums[i]>max
                        if (len(nums[i])>len(max)){
                            if (Integer.bitCount( nums[i]^max)==1){

                                rtn[i]=1;
                                max=nums[i];
                            }else{
                                rtn[i]=rtn[i+1]+1;
                                max=nums[i]|max;
                            }
                        }else{ //位相同
                            if ((nums[i]|max)==nums[i]){
                                rtn[i]=1;
                                max=nums[i];
                            }else{ //有让 i 变大的数
                                max=nums[i]|max;
                                int scurl=1;
                                int sn=nums[i];
                                for (int j = i+1;sn<max&& j <i+1+ rtn[i+1]; j++) {
                                    sn|=nums[j];
                                    scurl++;
                                }
                                rtn[i]=scurl;
                            }
                        }
                    }
                }
            }
            return rtn;
        }
        private int len(int x){
            int rtn=0;
            while (x!=0){
                x>>=1;
                rtn++;
            }
            return rtn;
        }

    }
    class Solution2 {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);
            int i=0;
            int j=0;
            int rtn=0;
            while (i<players.length&&j<trainers.length){
                if (players[i]<=trainers[j]){
                    i++;
                    rtn++;
                }
                j++;
            }
            return rtn;
        }
    }
    class Solution1 {
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

            int[] alice = new int[]{toDay(arriveAlice), toDay(leaveAlice)};
            int[] bob = new int[]{toDay(arriveBob), toDay(leaveBob)};
            if (alice[0] <= bob[0] && alice[1] >= bob[0]) {
                return Math.min(alice[1], bob[1]) - bob[0]+1;
            }
            if (bob[0] <= alice[0] && bob[1] >= alice[0]){
                return Math.min(alice[1], bob[1]) - alice[0]+1;
            }
            return 0;
        }

        private int toDay(String md) {
            String[] aStart = md.split("-");
            Integer month = Integer.valueOf(aStart[0]);
            Integer day = Integer.valueOf(aStart[1]);
            int rtn = day;
            for (int i = 0; i < (month - 1); i++) {
                rtn += days[i];
            }
            return rtn;
        }
    }
}
