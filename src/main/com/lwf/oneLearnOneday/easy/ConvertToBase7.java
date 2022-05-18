package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/base-7/
 * 504. 七进制数
 * @author: liuwenfei14
 * @date: 2022-03-07 09:25
 */
public class ConvertToBase7 {
    /**
     * 辗转除余法，是所有进制的转换方法
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num==0){
            return "0";
        }
        StringBuilder stringBuilder=new StringBuilder();
        boolean f=true;
        if (num<0){
            f=false;
            num=Math.abs(num);
        }
        while (num>0){
            stringBuilder.append(num%7);
            num=num/7;
        }
        return f?stringBuilder.reverse().toString():stringBuilder.append("-").reverse().toString();
    }
}
