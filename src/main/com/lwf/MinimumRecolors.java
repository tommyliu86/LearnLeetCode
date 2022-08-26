package com.lwf;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MinimumRecolors {
    class Solution1 {
        public int minimumRecolors(String blocks, int k) {
            int l = 0;
            int r = 0;
            int max = k;
            int cur = 0;
            while (r < blocks.length()) {

                while (r < blocks.length() && r - l < k) {
                    if (blocks.charAt(r) == 'W') {
                        cur++;
                    }
                    r++;
                }
                max = Math.min(cur, max);
                if (blocks.charAt(l++) == 'W') {
                    cur--;
                }
            }
            return max;
        }
    }

    class Solution2 {
        public int secondsToRemoveOccurrences(String s) {
            char[] chars = s.toCharArray();
            boolean has = true;
            int count = 0;
            while (has) {
                boolean swap = false;
                for (int i = 0; i < chars.length - 1; i++) {
                    if (chars[i] == '0' && chars[i + 1] == '1') {
                        swap(chars, i, i + 1);
                        swap = true;
                        i = i + 1;
                    }
                }
                has = swap;
                if (has) count++;
            }
            return count;
        }

        private void swap(char[] chars, int l, int r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
        }
    }

    class Solution3 {
        public String shiftingLetters(String s, int[][] shifts) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < shifts.length; i++) {

                int l = shifts[i][0];
                int r = shifts[i][1];
                int sum = shifts[i][2] == 0 ? -1 : 1;
                for (int j = l; j <= r; j++) {
                    chars[j] = move(chars[j], sum);
                }
            }
            return String.valueOf(chars);
        }

        private char move(char a, int i) {
            if (a == 'a' && i == -1) {
                return 'z';
            } else if (a == 'z' && i == 1) {
                return 'a';
            } else {
                return (char) (a + i);
            }
        }
    }

    class Solution5 {
        public String shiftingLetters(String s, int[][] shifts) {
            char[] chars = s.toCharArray();
            int[] sums = new int[s.length()];
            for (int i = 0; i < shifts.length; i++) {
                int l = shifts[i][0];
                int r = shifts[i][1];
                int sum = shifts[i][2] == 0 ? -1 : 1;
                for (int j = l; j <= r; j++) {
                    sums[j] += sum;
                }
            }
            for (int i = 0; i < chars.length; i++) {
                chars[i] = move(chars[i], sums[i]);
            }
            return String.valueOf(chars);
        }

        private char move(char a, int i) {
            int newA = (a - 'a' + i) % 26;
            if (newA < 0) {
                return (char) ('z' + 1 + newA);
            } else {
                return (char) ('a' + newA);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().maximumSegmentSum(new int[]{1, 2, 5, 6, 1}, new int[]{
                0, 3, 2, 4, 1});
    }

    static class Solution {
        public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
            int l = nums.length;
            long[] sums = new long[l];
            sums[0] = nums[0];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }

            TreeMap<Integer,Integer> startEnd=new TreeMap<>(Integer::compareTo);
            long[] rtn = new long[nums.length];

            PriorityQueue<Long> queue = new PriorityQueue<>((a, b) -> -a.compareTo(b));
            for (int i = removeQueries.length - 1; i > 0; i--) {

                int[] ints = find(startEnd, removeQueries[i]);
                queue.add(sums[ints[1]] - (ints[0]==0?0: sums[ints[0]-1]));

                rtn[i - 1] = queue.peek();
            }

            return rtn;
        }
        public int[] find(TreeMap<Integer,Integer> sn, int i) {
            int l = i;
            Map.Entry<Integer, Integer> right = sn.ceilingEntry(i);
            Map.Entry<Integer, Integer> left = sn.floorEntry(i);
            if (right!=null&&left!=null&&  right.getKey()==l+1&&left.getValue()==l-1){
                sn.remove(right.getKey());
                sn.replace(left.getKey(),right.getValue());
                return new int[]{left.getKey(),right.getValue()};
            }else if (right!=null&& right.getKey()==l+1){
                sn.remove(right.getKey());
                sn.put(l,right.getValue());
                return new int[]{l,right.getValue()};
            }else if (left!=null&& left.getValue()==l-1){

                sn.replace(left.getKey(),l);
                return new int[]{left.getKey(),l};
            }else{
                sn.put(l,l);
                return new int[]{l,l};
            }
        }
        public int[] find(int[] mark, int i) {
            int l = i;
            while (l >= 0 && mark[l] == 1) {
                l--;
            }
            int r = i;
            while (r < mark.length && mark[r] == 1) {
                r++;
            }
            return new int[]{l, r};
        }

        public long sums(int[] nums, int l, int r) {
            long rtn = 0;
            for (int i = l; i < r; i++) {
                rtn += nums[i];
            }
            return rtn;
        }
    }
}
