package com.lwf.oneLearnOneday.normal;

/**
 * author Administrator
 * time 2019-09-19-23:50
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int max=0;
        for (int i = 0; i < height.length-1; i++) {
            int first=height[i];
            for (int j = i+1; j < height.length; j++) {

                max=Math.max(max,(j-i)*Math.min(height[j],first));
            }
        }
        return max;
    }
    public int maxArea1(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
       while (left!=right){
           max=Math.max(max,(right-left)* Math.min(height[left],height[right]));
           if (height[left]<height[right]){
               left++;
           }else{
               right--;
           }
       }
        return max;
    }
}
