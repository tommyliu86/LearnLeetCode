package com.lwf.learn.everyday.arith.second.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-28 10:58
 */
public class FindNumberOfLIS {

    class test {
        public int findNumberOfLIS(int[] nums) {
           List<List<Integer>> l=new ArrayList<>();
           List<List<Integer>> c=new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (l.size() == 0) {
                    l.add(new ArrayList<>(Arrays.asList(nums[i])));
                    c.add(new ArrayList<>(Arrays.asList(1)));
                } else {
                    int num = nums[i];
                    int j = half1(l, 0, l.size()-1, num);
                    List<Integer> list = l.get(j);
                    Integer lNum = list.get(list.size() - 1);
                    if (lNum> num) {
                        list.add(num);
                        if (j-1>-1){
                            List<Integer> list1 = l.get(j - 1);
                            int i1 = half2(list1, 0, list1.size() - 1, num);

                        }
                    }else if (lNum<num){
                        if
                        (j+1>l.size()) {
                            l.add(new ArrayList<Integer>(Arrays.asList(num)));
                        }else{
                            l.get(j+1).add(num);
                        }
                    }
                }

            }
            //todo
            return 0;
        }

        public int half1(List<List<Integer>> l, int left, int right, int t) {
            if (left >= right) {
                return left;
            }
            int mid = (left + right) / 2;
            List<Integer> list = l.get(mid);
            if (list.get(list.size()-1) == t) {
                return mid;
            } else if (list.get(list.size()-1) > t) {
                return half1(l, left, mid - 1, t);
            } else {
                return half1(l, mid + 1, right, t);
            }
        }
        public int half2(List<Integer> c, int left, int right, int t) {
            if (left >= right) {
                return left;
            }
            int mid = (left + right) / 2;
            Integer i = c.get(mid);
            if (i == t) {
                return mid;
            } else if (i > t) {
                return half2(c, mid+1, right, t);
            } else {
                return half2(c, left, mid-1, t);
            }
        }
    }

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int[] count = new int[nums.length];
            int[] l = new int[nums.length];
            int lmax = 0;
            int lcount = 0;
            for (int i = 0; i < nums.length; i++) {

                l[i] = 1;
                count[i] = 1;

                for (int j = i - 1; j >= 0; j--) {

                    if (nums[j] < nums[i]) {
                        if (l[i] < l[j] + 1) {

                            l[i] = l[j] + 1;
                            count[i] = count[j];
                        } else if (l[i] == l[j] + 1) {
                            count[i] += count[j];
                        }

                    }
                }

                if (l[i] > lmax) {
                    lmax = l[i];
                    lcount = count[i];
                } else if (l[i] == lmax) {
                    lcount += count[i];
                }

            }

            return lcount;
        }

    }
}
