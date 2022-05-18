package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA. User: liuwenfei14 Date: 2019-11-22 Time: 09:06
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '0') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int x, int y) {
        if (grid[x][y] != '0') {
            grid[x][y] = '0';
            if (x + 1 < grid.length) dfs(grid, x + 1, y);
            if (y + 1 < grid[0].length) dfs(grid, x, y + 1);
            if (x - 1 >= 0) dfs(grid, x - 1, y);
            if (y - 1 >= 0) dfs(grid, x, y - 1);
        }
    }

    class point{
        public Integer x;
        public Integer y;
        public point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    void bfs(char[][] grid,int x,int y){
        grid[x][y]='0';
        Queue<point> queue=new LinkedList<>();
        queue.add(new point(x,y));
        while (!queue.isEmpty()){
                point cur=queue.remove();

                if (cur.x+1<grid.length&&grid[cur.x+1][cur.y]!='0') {
                    grid[cur.x+1][cur.y]='0';  //需要在添加队列前就进行赋值，不然会导致入队列的重复，从而导致重复判断
                    queue.add(new point(cur.x+1,cur.y));
                }
                if (cur.x-1>=0&&grid[cur.x-1][cur.y]!='0') {
                    grid[cur.x-1][cur.y]='0';
                    queue.add(new point(cur.x-1,cur.y));
                }
                if (cur.y+1<grid[0].length&&grid[cur.x][cur.y+1]!='0') {
                    grid[cur.x][cur.y+1]='0';
                    queue.add(new point(cur.x,cur.y+1));
                }
                if (cur.y-1>=0&&grid[cur.x][cur.y-1]!='0'){
                    grid[cur.x+1][cur.y-1]='0';
                    queue.add(new point(cur.x,cur.y-1));
                }
        }
    }
}
