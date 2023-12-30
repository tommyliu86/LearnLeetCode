package com.lwf.oneLearnOneday.easy;

import java.time.LocalDate;

public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(LocalDate.of(1970, 12, 31).getDayOfWeek());
    }
    /**
     * 需要找到基准时间是星期几。。1970-12-31 ==星期四。。
     * 直接使用api不行会报错，只能通过计算了。。
     */

    class Solution {
        String[] names=new String[]{"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] dayOfMonth=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        public String dayOfTheWeek(int day, int month, int year) {
            int dis=4;
            for (int i = 1971; i < year; i++) {
                if (i%400==0||(i%100!=0&&i%4==0)){
                    dis+=366;
                }else{
                    dis+=365;
                }
            }
            for (int i = 0; i < month-1; i++) {

                dis+=dayOfMonth[i];
            }
            if (year%400==0||(year%100!=0&&year%4==0)&&month>2){
                dis+=1;
            }
            dis+=day;


            return names[dis%7];
        }
    }
}
