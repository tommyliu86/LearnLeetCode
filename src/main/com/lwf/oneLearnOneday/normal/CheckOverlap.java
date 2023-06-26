package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/6/25 8:57
 */
public class CheckOverlap {
    /**
     * 枚举大法，
     * 圆和矩形有重合可以分成两种情况，一种是圆心落在了矩形扩展radius出来的两个矩形，一种是在四个顶点处可能重合的情况，
     * 因此分别对比这两种情况即可
     */
    class Solution {
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            if ((xCenter>=x1-radius&&xCenter<=x2+radius&&yCenter>=y1&&yCenter<=y2)
                ||(xCenter>=x1&&xCenter<=x2&&yCenter>=y1-radius&&yCenter<=y2+radius)){
                return true;
            }
            if (Math.pow(xCenter-x1,2)+Math.pow(yCenter-y1,2)<radius*radius
               ||Math.pow(xCenter-x1,2)+Math.pow(yCenter-y2,2)<radius*radius
               ||Math.pow(xCenter-x2,2)+Math.pow(yCenter-y1,2)<radius*radius
               ||Math.pow(xCenter-x2,2)+Math.pow(yCenter-y2,2)<radius*radius
            ){
                return true;
            }
            return false;
        }
    }
}
