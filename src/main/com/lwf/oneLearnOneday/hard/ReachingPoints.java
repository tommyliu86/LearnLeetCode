package com.lwf.oneLearnOneday.hard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 08:36
 */
public class ReachingPoints {
    /**
     * 反向思路求解，反推
     * 从这些题可以看到，思路和找到核心问题的点非常重要，解题应用的算法是比较简单的，但是一定要找到切入点
     * tx、ty，如果 tx==ty，由于sx、sy！=0，则tx==ty肯定不能是累加上来的，只能是初始状态
     * tx！=ty时，tx=t[y]+t[x-1]||ty=t[x]+t[y-1] ,考虑极端情况 tx=1，ty=max，则表示。ty=t[y-n]+n*tx,因此
     * 算法可以使用mod计算剩余，省略中间的循环！
     */
    class test {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if (tx == ty) {
                return sx == sy && sx == tx;
            }
            while (tx > sx && ty > sy) {
                if (tx > ty) {
                    tx %= ty;
                } else {
                    ty %= tx;
                }
            }
            if (sx == tx) {

                return ty >= sy && (ty - sy) % sx == 0;
            } else if (sy == ty) {
                return tx >= sx && (tx - sx) % sy == 0;
            } else {
                return false;
            }
        }
    }

    /**
     * 暴力解法， a,b->a+b,a+b+b ,递归最后会导致Stack Overflow
     */
    class Solution {
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if (tx == ty) {
                return sx == sy && (sy == tx);
            }
            return recurse(sx, sy, tx, ty);
        }

        public boolean recurse(int sx, int sy, int tx, int ty) {
            if (sx == tx && sy == ty) {
                return true;
            }
            if (sx > tx || sy > ty) {
                return false;
            }
            return recurse(sx + sy, sy, tx, ty) || recurse(sx, sx + sy, tx, ty);
        }
    }
}
