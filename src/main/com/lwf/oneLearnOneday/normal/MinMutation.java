package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-07 09:10
 */
public class MinMutation {
    class Solution {
        public int minMutation(String start, String end, String[] bank) {

            Set<String> set = new HashSet<>();
            for (int i = 0; i < bank.length; i++) {
                set.add(bank[i]);
            }
            if (!set.contains(end)) {
                return -1;
            }
            if (start.equals(end)) {
                return 0;
            }
            int time = 1;
            Queue<String> queue = new LinkedList<>();
            queue.add(end);
            set.remove(end);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();

                    List<String> list = new ArrayList<>();
                    char[] chars1 = poll.toCharArray();
                    for (int j = 0; j < poll.length(); j++) {
                        char c = chars1[j];
                        for (int k = 0; k < this.chars.length; k++) {
                            if (this.chars[k] != c) {
                                chars1[j] = chars[k];
                                list.add(String.valueOf(chars1));
                                chars1[j] = c;
                            }
                        }
                    }
                    for (int j = 0; j < list.size(); j++) {
                        if (start.equals(list.get(j))) {
                            return time;
                        }
                        if (set.contains(list.get(j))) {
                            queue.add(list.get(j));
                            set.remove(list.get(j));
                        }
                    }

                }
                time++;
            }
            return -1;
        }

        char[] chars = new char[]{'A', 'C', 'G', 'T'};
    }
}
