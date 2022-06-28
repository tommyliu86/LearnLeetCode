package com.lwf.oneLearnOneday.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-23 14:26
 */
public class FindSubstring {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman",
                new String[]{"foo", "bar"}));
    }

    /**
     * 暴力解法，首先用map存储首字母和单词的index列表，这样在相同长度字符串上进行等长字符串的比对，查找是否全匹配。
     */
    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {

            List<Integer> rtn = new ArrayList<>();


            int n = words.length;
            int l = words[0].length();
            //key是首字母，value是index
            Map<Character, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                List<Integer> list = map.getOrDefault(words[i].charAt(0), new ArrayList<>());
                list.add(i);
                map.put(words[i].charAt(0), list);
            }
            for (int i = 0; i + n * l <= s.length(); i++) {

                boolean[] used = new boolean[n];

                for (int j = i; j < i + n * l; j += l) {
                    if (!map.containsKey(s.charAt(j))) {
                        break;
                    }

                    List<Integer> valueList = map.get(s.charAt(j));
                    String substring = s.substring(j, j + l);

                    boolean find = false;
                    for (int k = 0; k < valueList.size(); k++) {
                        Integer index = valueList.get(k);
                        if (words[index].equals(substring)) {
                            if (used[index]) {
                                continue;
                            } else {
                                used[index] = true;
                                find = true;
                                break;
                            }
                        }
                    }
                    if (!find) {
                        break;
                    }
                }
                boolean ok = true;
                for (int j = 0; j < used.length; j++) {
                    ok = used[j];
                    if (!ok) {
                        break;
                    }
                }
                if (ok) {
                    rtn.add(i);
                }

            }
            return rtn;
        }
    }
}
