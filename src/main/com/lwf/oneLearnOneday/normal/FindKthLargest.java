package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-26 Time: 09:26
 */
public class FindKthLargest {
    /**
     * 暴力法，直接排序后找元素index
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {

    }
    public int findKthLargest(int[] nums,int k){

        singleHeap(nums,k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i]>nums[0]){
                int temp =nums[0];
                nums[0]=nums[i];
                nums[i]=temp;
                singleHeap(nums,k);
            }
        }
        return nums[0];
    }
    public void createHeap(int[] nums,int length) {
      //构建小根堆

        for (int i = 1; i < length; i+=2) {
            int left=i;
            int parent=(left-1)/2; //find the parent node
            int right=parent*2+2;
            if (right>=length) right=length-1;
            while (parent>=0&&(nums[left]<nums[parent]||nums[right]<nums[parent])){
                int needswap=nums[left]<nums[right]?left:right;
                int temp=nums[needswap];
               nums[needswap]=nums[parent];
                nums[parent]=temp;
                parent=(parent-1)/2; //swap cur and parent until root(0)
                left=parent*2+1;
                right=parent*2+2;
            }
        }
    }

    /**
     * 有问题，单个节点向上推举，但是会兄弟节点未做对比
     * @param nums
     * @param length
     */
    public void singleHeap(int[] nums,int length) {
        //构建小根堆
        for (int i = 1; i < length; i++) {
            int cur=i;
            int parent=(cur-1)/2; //find the parent node
            while (parent>=0&&nums[cur]<nums[parent]){
                int temp=nums[i];
                nums[i]=nums[parent];
                nums[parent]=temp;
                int j=cur;
               while (j*2+1<length){
                    int left=j*2+1;
                    int right=j*2+2;
                    if (nums[j]>nums[left]||nums[j]>nums[right]){
                            int min=nums[left]<nums[right]?left:right;
                            int tem=nums[min];
                            nums[min]=nums[j];
                            nums[j]=tem;
                            j=min;

                    }else{
                        break;
                    }
                }
                cur=parent;
                parent=(parent-1)/2; //swap cur and parent until root(0)
            }
        }
    }


}
