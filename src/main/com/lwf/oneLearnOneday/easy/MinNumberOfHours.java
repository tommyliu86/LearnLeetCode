package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/3/13 12:32
 */
public class MinNumberOfHours {
    class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int ans=0;
            for (int i = 0; i < energy.length; i++) {
                initialEnergy-=energy[i];
                int temp= initialExperience-experience[i]>0?0:(experience[i]-initialExperience+1);
                initialExperience+=experience[i]+temp;
                ans+=temp;
            }
            return ans+(initialEnergy>0?0:(1+(-1*initialEnergy)));
        }
    }
}
