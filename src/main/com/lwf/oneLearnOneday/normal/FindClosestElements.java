package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindClosestElements {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            if (k >= arr.length) {
                List<Integer> rtn = new ArrayList<>();
                for (int i : arr) {
                    rtn.add(i);
                }
                return rtn;
            }
            int index = halfFind(arr, 0, arr.length - 1, x);


            int l = arr[ index]>=x?index-1:index;
            int r =arr[ index]>=x?index:index+1;
            while (r - l < k + 1) {
                if (l < 0) {
                    r++;
                } else if (r >= arr.length) {
                    l--;
                } else {
                    if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                        l--;
                    } else {
                        r++;
                    }
                }
            }
            int[] ints = Arrays.copyOfRange(arr, l + 1, r);
            List<Integer> rtn = new ArrayList<>();
            for (int i : ints) {
                rtn.add(i);
            }
            return rtn;


        }

        private int halfFind(int[] arr, int l, int r, int t) {
            if (l >= r) {
                return l;
            }
            int m = (l + r) / 2;
            if (arr[m] == t) {
                return m;
            } else if (arr[m] > t) {
                return halfFind(arr, l, m - 1, t);
            } else {
                return halfFind(arr, m + 1, r, t);
            }
        }
    }
}
