package com.lwf.TOP100.hard;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.LongFunction;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/find-the-closest-palindrome/
 * 564. 寻找最近的回文数
 * @author: liuwenfei14
 * @date: 2022-03-02 09:53
 */
public class NearestPalindromic {
    public static void main(String[] args) {
        char c1='1';
        c1-=1;
        System.out.println(c1);
        String s="9999999999999999";
        long l = Long.parseLong(s);
        System.out.println(l);
        System.out.println(Long.MAX_VALUE);
        NearestPalindromic nearestPalindromic = new NearestPalindromic();
        System.out.println(nearestPalindromic.nearestPalindromic("1903828091"));
    }

    /**
     * 首先考虑回文结构，是 char[i]==char[n-i],因此第一步我们用首尾指针直接构建回文字符串first，如果first==self，表示自身就是回文，那么我们需要构建离self最近的两个回文。否则根据比较的大小来确定需要构建大或小的回文串。
     * 如何构建最近的回文串？这里考虑回文结构特点，由于任意一个不在中间的低位数字的变化都会影响到高位，因此可以知道最中间的变化是影响最小的地方，因此构建子方法，从mid开始进行模拟运算即可。这里模拟只需要考虑进位和借位的计算就ok了
     *
     * 作者：tommy-23
     * 链接：https://leetcode-cn.com/problems/find-the-closest-palindrome/solution/shu-zu-mo-ni-ji-suan-so-easy-by-tommy-23-yinx/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public String nearestPalindromic(String n) {
        if (n.length()<2){
            int intN=Integer.valueOf(n)-1;
            return String.valueOf(intN);
        }

        char[] chars = n.toCharArray();
        int left=0;
        int right=chars.length-1;
        while (left<right){
            chars[right]=chars[left];
            left++;
            right--;
        }
        long c1=Long.valueOf(String.valueOf(chars));
        long self=Long.valueOf(n);
        long min=0,max=0;
        if (c1==self){
             max = getPa(chars, left > right ? right : left, right > left ? right : left, true);
             min = getPa(chars, left > right ? right : left, right > left ? right : left, false);
        }else if (c1>self){
            min = getPa(chars, left > right ? right : left, right > left ? right : left, false);
            max=c1;
        }else{
            min=c1;
            max = getPa(chars, left > right ? right : left, right > left ? right : left, true);
        }


        long abs = Math.abs(self - min);
        if (Math.abs(max - self)<abs){
            return String.valueOf(max);
        }else{
            return String.valueOf(min);
        }
    }

    public long getPa(char[] source,int left,int right,boolean add){
        char[] charMin=new char[source.length];
        int mid=add?1:-1;
        int minL=left;
        int minR=right;
        while (minL>0) {
            if (source[minL]=='0'&&mid==-1) {
                mid=-1;
                charMin[minL]='9';
                charMin[minR]='9';
            }else if (source[minL]=='9'&&mid==1) {
                mid=1;
                charMin[minL]='0';
                charMin[minR]='0';
            }
            else{
                charMin[minL]=(char)( source[minL]+mid);
                charMin[minR]=(char)( source[minL]+mid);
                mid=0;
            }
            minL--;
            minR++;
        }
        if (source[minL]=='1'&&mid==-1){
            charMin[0]='9';
            charMin[minR]='0';
            char[] chars =  Arrays.copyOf(charMin, charMin.length -1);
            charMin=chars;
        }else if (source[minL]=='9'&&mid==1){
            charMin[0]='1';
            charMin[minR]='0';
            char[] chars =  Arrays.copyOf(charMin, charMin.length + 1);
            chars[chars.length-1]='1';
            charMin=chars;
        }else {
            charMin[minL]=(char)( source[minL]+mid);
            charMin[minR]=(char)( source[minL]+mid);
        }
        return Long.valueOf(String.valueOf( charMin));
    }
}
