package com.lwf.data;

/**
 * @author liuwenfei
 * @date 2023/2/1 9:27
 */
public class Sort {
    public static void main(String[] args) {
        int[] ints = {12, 3, 5, 76, 8, 6, 3, 4, 6, 89};
        new Sort().fastSort2(ints,0,9);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    /**
     * 快速排序，使用一个指针从前到后的遍历，会比前后指针好写很多
     * @param arr
     * @param l
     * @param r
     */
    public void fastSort2(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        int m=arr[l];
        //小于等于基准的最后一个位置，这个位置很重要
        int i=l;
        for (int j = l+1; j <= r; j++) {
            if (arr[j]<=m){
                //如果数小于基准，则应该放到++i，大于的不需要移动，类似滑动窗口
                int temp=arr[++i];
                arr[i]=arr[j];
                arr[j]=temp;

            }
        }

        arr[l]=arr[i];
        arr[i]=m;
        fastSort2(arr,l,i-1);
        fastSort2(arr,i+1,r);
    }

    /**
     * 快速排序 前后双指针，基准数是在中间位置的
     * @param arr
     * @param l
     * @param r
     */
    public void fastSort1(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        int m=arr[l];
        int i=l+1,j=r;
        while (i<=j){
            //i找大，j找小
            while (i<=j&&arr[i]<m) i++;
            while(i<=j&&arr[j]>m) j--;
            if (i>=j) break;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        //基准数放到i==j的位置
        arr[l]=arr[j];
        arr[j]=m;
        fastSort1(arr,l,j-1);
        fastSort1(arr,j+1,r);
    }
}
