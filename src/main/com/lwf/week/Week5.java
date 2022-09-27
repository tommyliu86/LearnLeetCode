package com.lwf.week;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/9/24 20:11
 */
public class Week5 {
    class Solution3 {
        public int[][] ballGame(int num, String[] plate) {
            max=num;
            List< int[]> rtn=new ArrayList<>();
            for (int i = 1; i < plate.length-1; i++) {
                if (plate[i].charAt(0)=='.'){

                int[] p=new int[]{ i,0} ;
                if (dfs(p,0,new HashSet<int[]>(),0,plate)){
                    rtn.add(p);
                }
                }
            }
            for (int i = 1; i < plate.length-1; i++) {
                if (plate[i].charAt(plate[0].length() - 1)=='.') {

                    int[] p = new int[]{i, plate[0].length() - 1};
                    if (dfs(p, 2, new HashSet<int[]>(), 0, plate)) {
                        rtn.add(p);
                    }
                }
            }
            for (int i = 1; i < plate[0].length()-1; i++) {
                if (plate[0].charAt(i)=='.') {

                    int[] p = new int[]{0, i};
                    if (dfs(p, 1, new HashSet<int[]>(), 0, plate)) {
                        rtn.add(p);
                    }
                }
            }
            for (int i = 1; i < plate[0].length()-1; i++) {
                if (plate[plate.length - 1].charAt(i)=='.') {

                    int[] p = new int[]{plate.length - 1, i};
                    if (dfs(p, 3, new HashSet<int[]>(), 0, plate)) {
                        rtn.add(p);
                    }
                }
            }
            int[][] ans=new int[rtn.size()][2];
            for (int i = 0; i < ans.length; i++) {
               ans[i]= rtn.get(i);
            }
            return  ans;
        }

        int[][] tos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max=0;
        private boolean dfs(int[] point, int to, Set<int[]> paths, int num, String[] plate) {
            int x = point[0];
            int y = point[1];
            if (plate[x].charAt(y) == 'O') {
                return true;
            }
            int[] next=new int[2];
            if (plate[x].charAt(y) == 'E') {
                to=(to+1)%4;
            } else if (plate[x].charAt(y) == 'W') {
                to=(to-1+4)%4;
            }

            next[0]=point[0]+tos[to][0];
            next[1]=point[1]+tos[to][1];
            if (next[0]>=0&&next[0]<plate.length&&next[1]>=0&&next[1]<plate[0].length()&&!paths.contains(next)&&num<max){
                paths.add(next);
                return dfs(next,to,paths,num+1,plate);
            }else{
                return false;
            }
        }
    }

    class Solution2 {
        public int transportationHub(int[][] path) {
            int[] parents = new int[1001];
            int[] counts = new int[1001];
            Set<Integer> nodes = new HashSet<>();
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            for (int i = 0; i < path.length; i++) {
                int[] ints = path[i];
                nodes.add(ints[0]);
                nodes.add(ints[1]);
                counts[ints[1]]++;
                parents[ints[0]] = ints[1];
            }
            int n = nodes.size();
            for (Integer node : nodes) {
                if (parents[node] == node && counts[node] == n - 1) {
                    return node;
                }
            }
            return -1;
        }
    }

    class Solution1 {
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
            int n = temperatureA.length;
            int[] ta = new int[n - 1];
            int[] tb = new int[n - 1];
            for (int i = 1; i < temperatureA.length; i++) {

                ta[i - 1] = Integer.compare(temperatureA[i], temperatureA[i - 1]);
                tb[i - 1] = Integer.compare(temperatureB[i], temperatureB[i - 1]);

            }
            int max = 0;
            int left = 0;
            while (left < ta.length) {
                if (ta[left] != tb[left]) {
                    left++;
                } else {
                    int r = left + 1;
                    while (r < ta.length && ta[r] == tb[r]) {
                        r++;
                    }
                    max = Math.max(r - left + 1, max);
                    left = r;
                }
            }
            return max;
        }
    }
}
