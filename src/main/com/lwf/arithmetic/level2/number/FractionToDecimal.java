package com.lwf.arithmetic.level2.number;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 14:09
 */
public class FractionToDecimal {
    public static void main(String[] args) {
        System.out.println(-400%-333);
        StringBuilder builder = new StringBuilder();
        builder.append("123");
        builder.insert(1,"(");
        System.out.println(builder.toString());
        System.out.println((double)1/17);
    }
    /**
     * 使用出除余法来进行计算
     */
    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (denominator==1||denominator==-1) {
                return String.valueOf((long) numerator / denominator);
            }
            StringBuilder builder = new StringBuilder();
            long n;
            long d;
            if ((numerator>0&&denominator<0)||(numerator<0&&denominator>0)){
                builder.append("-");
                n=Math.abs(numerator);
                d=Math.abs(denominator);
            }else{
                n=numerator;
                d=denominator;
            }
            long i = n / d;
            n=n%d;
            builder.append(i);
            if (n==0){
                return builder.toString();
            }
            builder.append(".");
            HashMap<Long,Integer> set=new HashMap<>();
            while (n!=0&&!set.containsKey(n)){
                set.put(n,builder.length());
                i=n*10/d;
                n=n*10 %d;
                builder.append(i);
            }
            if (n==0) {
                return builder.toString();
            }else{
                Integer integer = set.get(n);
                builder.insert(integer,"(");
                return builder.append(")").toString();
            }

        }
    }
    /**
     * 这种方法无法根据小数某一个位数重复来判断后续是否重复，因此不可取。
     */
    class Solution1 {
        public String fractionToDecimal(int numerator, int denominator) {
            double d=(double) numerator/denominator;
            int i=(int)d;
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            if (d-(double) i==0d){
                return builder.toString();
            }
            d=d-(double)i;
            builder.append(".");
            List<Integer> list=new ArrayList<>();
            List<Integer>[] indexs=new List[10];
            for (int j = 0; j < indexs.length; j++) {
                indexs[j]=new ArrayList<>();
            }
            int index= -1;
            while (d!=0d){
                i= (int)(d*10);
                list.add(i);
                indexs[i].add(list.size()-1);
                d=d*10-(double)i;
                if (i!=0){
                    index = isdu(list, indexs, i);
                    if (index!=-1){
                        break;
                    }
                }
            }
            if (index==-1){
                for (int j = 0; j < list.size(); j++) {

                    builder.append(list.get(j));
                }
            }else{
                for (int j = 0; j < index; j++) {
                    builder.append(list.get(j));
                }
                builder.append("(");
                for (int j = index; j <(list.size()- index)/2+index; j++) {
                    builder.append(list.get(j));
                }
                builder.append(")");
            }
            return builder.toString();


        }
        public int isdu(List<Integer> list,List<Integer>[] indexs,int i){
            int r=list.size()-1;
            List<Integer> index = indexs[i];
            for (int j = index.size() - 2; j >= 0; j--) {
                int i1= index.get(j);
                int i2=r;
                while ( i1>=0&& i2!=index.get(j)){
                    if (list.get(i2)==list.get(i1)) {
                       i2--;
                       i1--;
                    }else{
                        break;
                    }
                }
                if (i2==index.get(j)){
                    return i1+1;
                }
            }
            return -1;
        }
    }
}
