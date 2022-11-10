package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/11/10 8:49
 */
public class ShortestPathAllKeys {
    /**
     * 注意| ^ & 的使用，异或是不相等为1，相等为0，或是任意为1
     */
    class Solution {
         int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int shortestPathAllKeys(String[] grid) {
            int[] start=new int[2];
            Map<Character,Integer> keys=new HashMap<>();
            int m = grid.length;
            int n = grid[0].length();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i].charAt(j)=='@') {
                        start[0]=i;
                        start[1]=j;
                    }else if (grid[i].charAt(j)>='a'&&grid[i].charAt(j)<='f'){
                        keys.put(grid[i].charAt(j),keys.size());
                    }
                }
            }
            int[][][] maps=new int[m][n][1<<keys.size()];
            Queue<int[]> queue=new LinkedList<>();
            queue.offer(new int[]{start[0],start[1],0});
            maps[start[0]][start[1]][0]=1;
            int ans=0;
            while (!queue.isEmpty()){
                ans++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    int path = poll[2];
                    for (int j = 0; j < steps.length; j++) {
                        int nx=poll[0]+steps[j][0];
                        int ny=poll[1]+steps[j][1];
                        if (nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx].charAt(ny)!='#' ){
                            char c = grid[nx].charAt(ny);
                            int npath=path;
                            if (c>='a'&&c<='f') {
                                npath = npath | (1 << keys.get(c));
                                if (npath==(1<<keys.size())-1){
                                    return ans;
                                }

                            }else if (c>='A'&&c<='F'){
                                int lock=keys.get(Character.toLowerCase(c));
                                if ((npath&(1<<lock))==0){
                                    continue;
                                }

                            }

                            if (maps[nx][ny][npath]==0){
                                maps[nx][ny][npath]=1;
                                queue.offer(new int[]{nx,ny,npath});
                            }

                        }
                    }
                }
            }

            return -1;
        }
    }
}
