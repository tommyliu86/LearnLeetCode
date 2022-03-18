package com.lwf.TOP100.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/utf-8-validation/
 * 393. UTF-8 编码验证
 * @author: liuwenfei14
 * @date: 2022-03-17 19:00
 */
public class ValidUtf8 {
    /**
     * 优化了一下对元素进行计算的方法，整体思路不变。。
     */
    public  class test1{
        public boolean validUtf8(int[] data) {
            int index=0;
            while (index<data.length){
                int datum = data[index];
                int bit = getBit(datum);
                if (bit==-1||bit==1){
                    return false;
                }
                int post=index+bit;
                if (post>data.length){
                    return false;
                }
                while (++index<post){
                    int bit1 = getBit(data[index]);
                    if (bit1!=1){
                        return false;
                    }
                }
            }
            return true;
        }
        public int getBit(int number){
            int i1 = number >> 7;
            if (i1==0){
                return 0;
            }
            int i2=number>>6;
            if((i2^((1<<2)-1))==1){
                return 1;
            }
            int i3=number>>5;
            if((i3^((1<<3)-1))==1){
                return 2;
            }
            int i4=number>>4;
            if((i4^((1<<4)-1))==1){
                return 3;
            }
            int i5=number>>5;
            if((i5^((1<<5)-1))==1){
                return 4;
            }else{
                return -1;
            }
        }
    }
    /**
     * 暴力解法，遍历，校验每个元素是否符合要求，从第一个元素开始检查，每次大循环都把当前是几个字节的元素全部检查，若符合要求，则继续
     * 向后走，若不符合则直接返回false；
     * @param data
     * @return
     */
    public boolean validUtf8(int[] data) {
        int index=0;
        while (index<data.length){
            int datum = data[index];
            int j=-1;
            if (getInt(datum,4)){
                j=3;
            }else if (getInt(datum,3)){
                j=2;
            }else if(getInt(datum,2)){
                j=1;
            }else if (getInt(datum,0)){
                index++;
                continue;
            }
            if (j==-1){
                return false;
            }else{
                int post=index+j;
                if (post>=data.length){
                    return false;
                }
                while (++index<=post){
                    if (!getInt(data[index],1)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean getInt(int number,int bit){
        int i4 = number >>(8- bit)-1;
        if ((i4+2)==(1<<bit+1)){
            return true;
        }else{
            return false;
        }
    }
}
