package com.lwf.oneLearnOneday.normal;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-05 09:51
 */
public class RandPoint {
    class Solution {
        double rad;
        double x;
        double y;
        Random random;
        public Solution(double radius, double x_center, double y_center) {
            this.rad=radius;
            x=x_center;
            y=y_center;
            random=new Random();
        }

        public double[] randPoint() {

            double newx = random.nextDouble() * 2 * rad - rad;
            double newy = random.nextDouble() * 2 * rad - rad;
            while (newx*newx+newy*newy>rad*rad){
                 newx = random.nextDouble() * 2 * rad - rad;
                 newy = random.nextDouble() * 2 * rad - rad;
            }
            return new double[]{x+newx,y+newy};
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
}
