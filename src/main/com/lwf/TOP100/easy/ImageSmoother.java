package com.lwf.TOP100.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/image-smoother/
 * 661. 图片平滑器
 * @author: liuwenfei14
 * @date: 2022-03-24 09:30
 */
public class ImageSmoother {
    /**
     * 前缀和方法--这种方法叫前缀和
     * 预先进行数组处理，计算每个点的前缀和，利用前缀和快速求和。
     */
    class Solution {
        public int[][] imageSmoother(int[][] img) {
            for (int i = 0; i < img.length; i++) {
                for (int j = 1; j < img[i].length; j++) {
                    img[i][j]+=img[i][j-1];
                }
            }
            int[][] rtn=new int[img.length][img[0].length];
            for (int i = 0; i < rtn.length; i++) {
                for (int j = 0; j < rtn[i].length; j++) {
                   rtn[i][j]= find(i, j, img);
                }
            }
            return rtn;
        }
        private int find(int i,int j,int[][]img){
            int[] min=new int[2];
            min[0]=i-1>=0?i-1:i;
            min[1]=j-1>=0?j-1:j;
            int[] max=new int[2];
            max[0]=i+1<img.length?i+1:i;
            max[1]=j+1<img[0].length?j+1:j;
            int count = max[0] - min[0]+1;
            int jCount=max[1]-min[1]+1;
            int sum=0;
            for (int k = 0; k < count; k++) {
                sum+=img[k+min[0]][max[1]]- min[1]==0?0: img[k+min[0]][min[1]-1];
            }
            return  sum/(count*jCount);
        }

    }
}
