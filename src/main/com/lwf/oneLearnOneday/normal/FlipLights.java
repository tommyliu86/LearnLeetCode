package com.lwf.oneLearnOneday.normal;

import javax.swing.plaf.synth.SynthTableUI;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author liuwenfei
 * @date 2022/9/15 9:03
 */
public class FlipLights {
    class Solution {
        public int flipLights(int n, int presses) {
            Set<Integer> status=new HashSet<>();
            //枚举所有的按压按键的组合，每个按键最终态只有按和不按
            for (int i = 0; i < 1<<4; i++) {
                int pressed = Integer.bitCount(i);
                int[] press=new int[4];
                for (int j = 0; j < 4; j++) {
                    press[j]=(i>>j)&1;
                }
                //按压的次数和presses奇偶性相同而且小于presses，因为通过偶数次按压可以复位按键状态
                if ((pressed&1)==(presses&1)&& pressed<=presses){
                    //第一个位置
                    int s=press[0]^press[2]^press[3];
                    //第二个
                    if (n>1){
                        s|=(press[0]^press[1])<<1;
                    }
                    //第三个
                    if (n>2){
                        s|=(press[0]^press[2])<<2;
                    }
                    //第四个
                    if (n>3){
                        s|=(press[0]^press[1]^press[3])<<3;
                    }
                    status.add(s);
                }

            }
            return status.size();

        }
    }
}
