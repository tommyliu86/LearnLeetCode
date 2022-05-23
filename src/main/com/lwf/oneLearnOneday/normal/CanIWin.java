package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 记忆华搜索-在遍历所有可能性的时候，把已经枚举过的可能性结果记录下来，这样在过程中可以重复使用结果，
 * 路径压缩-
 * 位运算应用，在不重复选择时，一般可以使用位运算来表示是否已经选择过。这样在进行记录时可以方便的进行计算。使用位运算！！
 *
 * @author: liuwenfei14
 * @date: 2022-05-22 21:31
 */
public class CanIWin {
    class Solution {
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
