package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/8/21 8:42
 */
public class CanChange {
    // -L 比target小 ，-R 比target 大 LR 顺序不一致
    class Solution {
        public boolean canChange(String start, String target) {
            int i = 0, i1 = 0;
            int n = start.length();
            while (i1 < n) {

                //1.找到target中不是'_'的字符
                while (i1 < n && target.charAt(i1) == '_') {
                    i1++;
                }
                //2.找到start中不是'_'的字符
                while (i < n && start.charAt(i) == '_') {
                    i++;
                }
                //3.如果其中一个字符串的指针到达末尾，检查两个指针是否都到达末尾
                if (i1 == n || i == n) {
                    return i == n && i1 == n;
                }
                //4.检查两个字符是否相同，和是否满足'L'在右边，'R'在左边的条件
                if (start.charAt(i) != target.charAt(i1) || (start.charAt(i) == 'L' && i < i1) || (start.charAt(i) == 'R' && i > i1)) {
                    return false;
                }
                i++;
                i1++;
            }
            //5.检查最后一个指针在start中是否到达末尾
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            return i == n && i1 == n;
        }
    }

}

