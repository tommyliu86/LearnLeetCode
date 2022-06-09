package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-09 09:29
 */
public class SolutionPick {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int i1 = random.nextInt(1);
            System.out.println(i1);
        }
    }
    class Solution {
        Random random;
        List<Integer> size;
        int[][] rects;

        public Solution(int[][] rects) {
            this.rects = rects;
            random = new Random();
            size = new ArrayList<>();
            for (int i = 0; i < rects.length; i++) {
                int[] rect = rects[i];
                int num = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
                int pre = size.size() > 0 ? size.get(size.size() - 1) : 0;
                size.add(num + pre);
            }
        }

        public int[] pick() {
            //这里的k是要查找的第几个点，从1开始的，而不是直接的index值，因此最后结果需要+1
            int k = random.nextInt(size.get(size.size() - 1)+1);
            int i = 0;
            for (int i1 = 0; i1 < size.size(); i1++) {
                if (size.get(i1) >= k) {
                    i = i1;
                    break;
                }
            }
            //这里的k是在指定的矩形中的节点的index值，因此需要-1，这里是非常容易忽略的地方
            k = k-1 - (i > 0 ? size.get(i - 1) : 0);
            int[] rect = rects[i];
            int ylentgh = rect[3] - rect[1] + 1;
            int xstep = k / ylentgh;
            int ystep = k -xstep* ylentgh;
            int newx = rect[0] + xstep;
            int newy = rect[1] + ystep;
            return new int[]{newx, newy};
        }
    }

    class Solution1 {
        Random rand;
        List<Integer> arr;
        int[][] rects;

        public Solution1(int[][] rects) {
            rand = new Random();
            arr = new ArrayList<Integer>();
            arr.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            int k = rand.nextInt(arr.get(arr.size() - 1));
            int rectIndex = binarySearch(arr, k + 1) - 1;
            k -= arr.get(rectIndex);
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }



/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
}
