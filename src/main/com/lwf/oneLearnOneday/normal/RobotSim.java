package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/7/19 8:26
 */
public class RobotSim {


    class Solution {

        public int robotSim(int[] commands, int[][] obstacles) {
            Set<Integer> points=new HashSet<>();
            for (int i = 0; i < obstacles.length; i++) {
                points.add(obstacles[i][0]*100000+obstacles[i][1]);
            }
            int max=0;
            int[] steps={0,1,0,-1,0};
            int cur=0,x=0,y=0;
            for (int i = 0; i < commands.length; i++) {
                int command = commands[i];
                if (command == -2) {
                    cur = (cur + 4 - 1) % 4;
                } else if (command == -1) {
                    cur = (cur + 4 + 1) % 4;
                } else {
                    for (int i1 = 0; i1 < command; i1++) {
                        int nx=steps[cur]+x;
                        int ny=steps[cur+1]+y;
                        if (points.contains(nx*100000+ny)){
                            break;
                        }
                        x=nx;
                        y=ny;
                    }
                    max=Math.max(max,x*x+y*y);
                }
            }
            return max;
        }
    }


    class Solution1 {
        Map<Integer, List<Integer>> xpoint=new HashMap<>();
        Map<Integer, List<Integer>> ypoint=new HashMap<>();
        public int robotSim(int[] commands, int[][] obstacles) {

            for (int i = 0; i < obstacles.length; i++) {
                int[] obstacle = obstacles[i];
                List<Integer> listx = xpoint.getOrDefault(obstacle[0], new ArrayList<>());
                listx.add(obstacle[1]);
                xpoint.put(obstacle[0],listx);
                List<Integer> listy = ypoint.getOrDefault(obstacle[1], new ArrayList<>());
                listy.add(obstacle[0]);
                ypoint.put(obstacle[1],listy);
            }
            xpoint.forEach((k,v)-> v.sort(Integer::compareTo));
            ypoint.forEach((k,v)-> v.sort(Integer::compareTo));

            int max=0;
            int[] steps={0,1,0,-1,0};
            int cur=0,x=0,y=0;
            for (int i = 0; i < commands.length; i++) {
                int command = commands[i];
                if (command==-2){
                    cur=(cur+5-1)%5;
                }else if (command==-1){
                    cur=(cur+5+1)%5;
                }else{
                    int nx=steps[cur]*command+x;
                    int ny=steps[cur+1]*command+y;
                    boolean findY=true;
                    if (ny==y) findY=false;
                    int[] dis = find(x, y, findY);
                    if (!findY){
                        if (nx<=dis[0]) {
                            nx=dis[0]+1;
                        }
                        if (nx>=dis[1]){
                            nx=dis[1]-1;
                        }
                    }else{
                        if (ny<=dis[0]) {
                            ny=dis[0]+1;
                        }
                        if (ny>=dis[1]){
                            ny=dis[1]-1;
                        }
                    }
                    x=nx;
                    y=ny;
                    max=Math.max(x*x+y*y,max);
                }
            }
            return max;
        }

        public int[] find(int x,int y,boolean findY){
            int[] ans=new int[2];
            ans[0]=Integer.MIN_VALUE;
            ans[1]=Integer.MAX_VALUE;
            List<Integer> list;
            int f;
            if (findY){
                if (!xpoint.containsKey(x)) {
                    return ans;
                }
                list=xpoint.get(x);
                f=y;
            }else{
                if (!ypoint.containsKey(y)) {
                    return ans;
                }
                list=ypoint.get(y);

                f=x;
            }

            if (list.get(0)>f){

                ans[1]=list.get(0);
                return ans;
            }else if (list.get(list.size()-1)<f){
                ans[0]=list.get(list.size()-1);

                return ans;
            }
            int i=0,j=list.size();
            while (i<j){
                int m=(i+j)/2;
                if (list.get(m)<f){
                    i=m+1;
                }else{
                    j=m;
                }
            }
            ans[0]=list.get(j-1);
            ans[1]=list.get(j);
            return ans;

        }
    }
}
