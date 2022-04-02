package com.lwf.oldtime;

import java.util.*;

/**
 * author Administrator
 * time 2019-08-03
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
//        System.out.println(isPerfectSquare.isPerfectSquare(16));
        System.out.println(isPerfectSquare.isPerfectSquare1(5));
    }
    public boolean isPerfectSquare(int num) {
        Set<Integer> set=new HashSet<>(Arrays.asList(0,1,4,5,6,9));
        int m=num%10;
        if (!set.contains(m)) return false;
        else    {
            int i=1;
            while (num>0){
                num=num-i;
                i+=2;
            }
            return num==0;
        }

    }

    public boolean isPerfectSquare1(int num) {
        Set<Integer> endset=new HashSet<>(Arrays.asList(0,1,4,5,6,9));
        if (!endset.contains(num%10)) return false;
        Map<Integer,Integer> startset=new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            startset.put(i,i*i);
        }
        List<Integer> nums=new LinkedList<>();
        int temp=num;
        while (temp!=0){
            nums.add(temp%10);
            temp/=10;
        }
        int min=0;
        int max=0;
        int temp1=0;
        int length=0;
        if ((nums.size()&1)==0){
            temp1=nums.get(nums.size()-1)*10+nums.get(nums.size()-2);
            length=nums.size()-2;
        }else{
            temp1=nums.get(nums.size()-1);
            length=nums.size()-1;
        }
        int index=1;
        while(startset.get(index)<=temp1){
            index++;
        }
        max=index*(int) Math.pow( 10, length/2);
        min=(index-1)*(int) Math.pow( 10, length/2);

        int mid=min+(max-min)/2;

        while (min<=max){
            if (mid>num/mid){
                max=mid-1;
            }else if(mid<num/mid){
                min=mid+1;
            }else{
                return num%mid==0;
            }
            mid=min+(max-min)/2;
        }
        return false;
    }

}

