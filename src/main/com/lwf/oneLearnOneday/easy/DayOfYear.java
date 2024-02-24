package com.lwf.oneLearnOneday.easy;

public class DayOfYear {
    class Solution {
        int[] days=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        public int dayOfYear(String date) {
            String[] split = date.split("-");
            int day=Integer.parseInt( split[2]);
            int month=Integer.parseInt(split[1]);
            for (int i = 0; i < month - 1; i++) {
                day+=days[i];
            }
            int year=Integer.parseInt(split[0]);
            if (month>2&&( year%400==0||(year%100!=0&&year%4==0))){
                day+=1;
            }

            return day;
        }
    }
}
