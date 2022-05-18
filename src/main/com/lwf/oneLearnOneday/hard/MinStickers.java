package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-14 17:13
 */
public class MinStickers {
    public static void main(String[] args) {
        int i = 7;
        System.out.println(i >> 3);
        System.out.println(i);
//                new Solution().minStickers(new String[]{"with","example","science"},
//        "thehat");
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }
    }

    static class Solution3 {
        /**
         * 思路仍然是递归解题，但是这里借助二进制表示target的子字符串，这样可以方便的记录。
         *
         * @param stickers
         * @param target
         * @return
         */
        public int minStickers(String[] stickers, String target) {
            int[] mark = new int[1 << target.length()];
            for (int i = 0; i < mark.length; i++) {
                mark[i] = -1;//表示初始化
            }
            mark[0] = 0;
            int recursive = recursive(stickers, target, (1 << target.length()) - 1, mark);
            if (recursive<=target.length()){
                return recursive;
            }else{
                return -1;
            }

        }

        public int recursive(String[] sticks, String target, int bit, int[] mark) {
            if (bit == 0) {
                return 0;
            }
            if (mark[bit] >= 0) {
                return mark[bit];
            }
            int num = target.length() + 1;
            for (int i = 0; i < sticks.length; i++) {
                int[] chars = new int[26];
                for (int j = 0; j < sticks[i].length(); j++) {
                    chars[sticks[i].charAt(j) - 'a']++;
                }
                int remain = bit;
                for (int j = 0; j < target.length(); j++) {
                    char c = target.charAt(j);
                    if ((remain >> j & 1) == 1 && chars[c - 'a'] > 0) {
                        remain ^= 1 << j;
                        chars[c - 'a']--;
                    }

                }
                if (remain < bit) {
                    int recursive = recursive(sticks, target, remain, mark);

                    num = Math.min(num, recursive + 1);

                }
            }
            mark[bit]=num;
            return num;

        }
    }

    static class Solution2 {
        /**
         * 思路仍然是递归解题，但是这里借助二进制表示target的子字符串，这样可以方便的记录。
         *
         * @param stickers
         * @param target
         * @return
         */
        public int minStickers(String[] stickers, String target) {
            int[] mark = new int[1 << target.length()];
            for (int i = 0; i < mark.length; i++) {
                mark[i] = -1;//表示初始化
            }
            mark[0] = 0;
            Set<Character> tset = new HashSet<>();
            List<Map<Character, Integer>> sticks = new ArrayList<>();
            for (int i = 0; i < target.length(); i++) {
                tset.add(target.charAt(i));
            }
            for (int i = 0; i < stickers.length; i++) {
                char[] chars1 = stickers[i].toCharArray();
                Map<Character, Integer> sub = new HashMap<>();
                for (int j = 0; j < chars1.length; j++) {
                    char c = chars1[j];
                    if (tset.contains(c)) {
                        sub.put(c, sub.getOrDefault(c, 0) + 1);

                    }
                }
                if (sub.size() > 0) {
                    sticks.add(sub);
                }

            }
            int recursive = recursive(sticks, target, (1 << target.length()) - 1, mark);
            if (recursive > target.length()) {
                return -1;
            } else {
                return recursive;
            }
        }

        public int recursive(List<Map<Character, Integer>> sticks, String target, int bit, int[] mark) {
            if (bit == 0) {
                return 0;
            }
            if (mark[bit] >= 0) {
                return mark[bit];
            }
            int num = target.length() + 1;
            for (int i = 0; i < sticks.size(); i++) {
                int remain = bit;

                Map<Character, Integer> map = new HashMap<>(sticks.get(i));
                boolean has = false;
                for (int j = 0; j < target.length(); j++) {


                    char c = target.charAt(j);
                    if (((remain >> j) & 1) == 1 && map.containsKey(c)) {
                        has = true;
                        remain ^= (1 << j);
                        if (map.get(c) == 1) {
                            map.remove(c);
                        } else {
                            map.put(c, map.get(c) - 1);
                        }
                    }
                }
                if (has) {

                    num = Math.min(num, recursive(sticks, target, remain, mark) + 1);
                }
            }


            mark[bit] = num;

            return mark[bit];
        }
    }

    static class Solution1 {
        /**
         * 暴力递归，会超时，使用额外辅助map记录每个剩余字符串的最小卡片个数，这样可以避免重复计算
         * 史上最慢。
         *
         * @param stickers
         * @param target
         * @return
         */
        public int minStickers(String[] stickers, String target) {

            char[] chars = target.toCharArray();
            Map<Character, Integer> map = new TreeMap<>(Character::compareTo);

            for (int i = 0; i < chars.length; i++) {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
            Set<Character> set = new HashSet<>(map.keySet());

            List<Map<Character, Integer>> sticks = new ArrayList<>();
            for (int i = 0; i < stickers.length; i++) {
                char[] chars1 = stickers[i].toCharArray();
                Map<Character, Integer> sub = new HashMap<>();
                for (int j = 0; j < chars1.length; j++) {
                    char c = chars1[j];
                    if (map.containsKey(c)) {
                        sub.put(c, sub.getOrDefault(c, 0) + 1);
                        set.remove(c);
                    }
                }

                if (sub.size() > 0) {
                    sticks.add(sub);
                }

            }
            if (set.size() > 0) {
                return -1;
            }
            return recursive(sticks, map);

        }

        Map<String, Integer> mark = new HashMap<>();


        public int recursive(List<Map<Character, Integer>> sticks, Map<Character, Integer> map) {
            if (map.size() == 0) {

                return 0;
            }

            int num = Integer.MAX_VALUE;
            for (int i = 0; i < sticks.size(); i++) {
                Map<Character, Integer> stick = sticks.get(i);
                if (contains(map.keySet(), stick.keySet())) {

                    Map<Character, Integer> retain = retain(map, stick);
                    String key = getKey(map);
                    if (mark.containsKey(key)) {

                        num = Math.min(num, mark.get(key) + 1);
                    } else {
                        num = Math.min(num, recursive(sticks, map) + 1);
                    }

                    for (Map.Entry<Character, Integer> entry : retain.entrySet()) {
                        map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                }
            }
            mark.put(getKey(map), num);

            return num;
        }

        private String getKey(Map<Character, Integer> map) {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                builder.append(entry.getKey()).append(entry.getValue());
            }
            return builder.toString();
        }

        private boolean contains(Set<Character> source, Set<Character> target) {
            for (Character integer : target) {
                if (source.contains(integer)) {
                    return true;
                }
            }
            return false;
        }

        private Map<Character, Integer> retain(Map<Character, Integer> map, Map<Character, Integer> stick) {
            Map<Character, Integer> rtn = new HashMap<>();
            for (Map.Entry<Character, Integer> entry : stick.entrySet()) {
                if (map.containsKey(entry.getKey())) {
                    Integer integer = map.get(entry.getKey());
                    entry.getValue();
                    rtn.put(entry.getKey(), Math.min(entry.getValue(), integer));
                    if (integer <= entry.getValue()) {
                        map.remove(entry.getKey());
                    } else {
                        map.put(entry.getKey(), integer - entry.getValue());
                    }
                }
            }
            return rtn;
        }
    }

    static class Solution {
        /**
         * 暴力递归，会超时，使用额外辅助map记录每个剩余字符串的最小卡片个数，这样可以避免重复计算
         *
         * @param stickers
         * @param target
         * @return
         */
        public int minStickers(String[] stickers, String target) {

            char[] chars = target.toCharArray();
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < chars.length; i++) {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
            Set<Character> set = new HashSet<>(map.keySet());

            List<Map<Character, Integer>> sticks = new ArrayList<>();
            for (int i = 0; i < stickers.length; i++) {
                char[] chars1 = stickers[i].toCharArray();
                Map<Character, Integer> sub = new HashMap<>();
                for (int j = 0; j < chars1.length; j++) {
                    char c = chars1[j];
                    if (map.containsKey(c)) {
                        sub.put(c, sub.getOrDefault(c, 0) + 1);
                        set.remove(c);
                    }
                }

                if (sub.size() > 0) {
                    sticks.add(sub);
                }

            }
            if (set.size() > 0) {
                return -1;
            }
            return recursive(sticks, map);

        }


        public int recursive(List<Map<Character, Integer>> sticks, Map<Character, Integer> map) {
            if (map.size() == 0) {

                return 0;
            }

            int num = Integer.MAX_VALUE;
            for (int i = 0; i < sticks.size(); i++) {
                Map<Character, Integer> stick = sticks.get(i);
                if (contains(map.keySet(), stick.keySet())) {

                    Map<Character, Integer> retain = retain(map, stick);

                    num = Math.min(num, recursive(sticks, map) + 1);

                    for (Map.Entry<Character, Integer> entry : retain.entrySet()) {
                        map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                }
            }

            return num;
        }

        private boolean contains(Set<Character> source, Set<Character> target) {
            for (Character integer : target) {
                if (source.contains(integer)) {
                    return true;
                }
            }
            return false;
        }

        private Map<Character, Integer> retain(Map<Character, Integer> map, Map<Character, Integer> stick) {
            Map<Character, Integer> rtn = new HashMap<>();
            for (Map.Entry<Character, Integer> entry : stick.entrySet()) {
                if (map.containsKey(entry.getKey())) {
                    Integer integer = map.get(entry.getKey());
                    entry.getValue();
                    rtn.put(entry.getKey(), Math.min(entry.getValue(), integer));
                    if (integer <= entry.getValue()) {
                        map.remove(entry.getKey());
                    } else {
                        map.put(entry.getKey(), integer - entry.getValue());
                    }
                }
            }
            return rtn;
        }
    }
}
