package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1146. 快照数组
 *
 * @author: liuwenfei
 * @date: 2024/4/26-8:53
 */
public class SnapshotArray1146 {
    /**
     * k-v结构，使用hash进行数据存储，版本单独使用版本号进行保存。
     */
    class SnapshotArray {

        Map<Integer, List<int[]>> map = new HashMap<>();
        int snap = 0;
        int count = 0;
        int l;

        public SnapshotArray(int length) {

            l = length;

        }

        public void set(int index, int val) {
            if (index >= l) {
                return;
            }
            List<int[]> list = map.compute(index, (k, v) -> v == null ? new ArrayList<>() : v);
            if (list.size() == 0) {
                list.add(new int[]{0, 0});
            }
            if (list.get(list.size() - 1)[0] == snap) {
                list.get(list.size() - 1)[1] = val;
            } else {
                list.add(new int[]{snap, val});
            }

        }

        public int snap() {

            snap++;
            return snap - 1;
        }

        public int get(int index, int snap_id) {

            if (map.containsKey(index)) {
                List<int[]> ints = map.get(index);
                return half(ints, snap_id);
            } else {
                return 0;
            }
        }
        //找第一个小于等于i的值
        private int half(List<int[]> list, int i) {
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (list.get(m)[0] > i) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (list.get(l)[0] > i) {
                return list.get(l-1)[1];
            } else {
               return list.get(l)[1];
            }
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
}
