package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * 记忆华搜索-在遍历所有可能性的时候，把已经枚举过的可能性结果记录下来，这样在过程中可以重复使用结果，
 * 路径压缩-
 * 位运算应用，在不重复选择时，一般可以使用位运算来表示是否已经选择过。这样在进行记录时可以方便的进行计算。使用位运算！！
 *
 *
 * @author: liuwenfei14
 * @date: 2022-05-22 21:31
 */
public class CanIWin {
    /**
     * 递归+记忆化，这里不考虑博弈的dp逆向，因为思路不对，这里的分数总和是前面获取的累加，因此是否可以获胜 f(i+1)=f(i)+剩余
     * 而且这里的剩余元素相同时也是有必然的获胜与否的，因为获取过的元素的和是固定的
     * 所以，这里记忆化是记录的剩余i个元素时，是否必然获胜
     */
    class Solution {
        Map<Integer,Boolean> sums=new HashMap<>();
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if ((maxChoosableInteger+1)*maxChoosableInteger/2<desiredTotal) {
                return false;
            }
           return dfs(maxChoosableInteger,desiredTotal,0,0);


        }
        public boolean dfs(int max,int total,int sum,int bitMark){
            if (sums.containsKey(bitMark)){
                return sums.get(bitMark);
            }
            boolean canWin=false;
            for (int i = 0; i < max; i++) {
                if ((bitMark&(1<<i))==0) {
                    if (sum+i+1>=total){
                        canWin=true;
                        break;
                    }else{
                        boolean dfs = dfs(max, total, sum + i + 1, bitMark | (1 << i));
                        if (!dfs){
                            canWin=true;
                            break;
                        }
                    }
                }
            }
            sums.put(bitMark,canWin);
            return canWin;
        }
    }
    class Solution1 {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger * (1 + maxChoosableInteger) / 2 < desiredTotal) {
                return false;
            }
            Map<Integer, Boolean> mark = new HashMap<>();
            return chose(maxChoosableInteger, desiredTotal, 0, 0, mark);
        }

        public boolean chose(int max, int target, int curBit, int sum, Map<Integer, Boolean> mark) {
            if (!mark.containsKey(curBit)) {
                boolean win=false;
                for (int i = 0; i < max; i++) {
                    if (((curBit >> i) & 1) == 0) {
                        if ((i+1)+sum>=target) {
                            win=true;
                            break;
                        }else{
                            win=!chose(max,target,(curBit|(1<<i)),sum+i+1,mark);

                            if (win){
                                break;
                            }
                        }
                    }
                }
                mark.put(curBit,win);
            }
            return mark.get(curBit);
        }

    }
}
