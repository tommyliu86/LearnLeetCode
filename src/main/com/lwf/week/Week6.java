package com.lwf.week;


import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/10/29 22:36
 */
public class Week6 {
    public static void main(String[] args) {
      new Solution().secondGreaterElement(new int[]{1,17,18,0,18,10,20,0});
    }
 static    class Solution {
        public int[] secondGreaterElement(int[] nums) {
            if (nums.length<=2){
               Arrays.fill(nums,-1);
               return nums;
            }
            int[] first=new int[nums.length];
            Arrays.fill(first,-1);
            Stack<Integer> firStack=new Stack<>();
            Stack<Integer> secStack=new Stack<>();

            int right=0;
            while (right<nums.length){
                while (!secStack.isEmpty()&& nums[ secStack.peek()]<nums[right]){
                    Integer pop = secStack.pop();
                    first[pop]=nums[right];
                }
                List<Integer> indexes=new ArrayList<>();
                while (!firStack.isEmpty()&&nums[firStack.peek()]<nums[right]){
                    Integer pop = firStack.pop();
                    indexes.add(pop);
                }
                for (int i = indexes.size() - 1; i >= 0; i--) {
                    Integer index = indexes.get(i);
                    while (!secStack.isEmpty()&& nums[ secStack.peek()]<nums[index]){
                        Integer pop = secStack.pop();
                        first[pop]=nums[index];
                    }
                    secStack.push(index);
                }
                firStack.push(right);
                right++;
            }
            return first;
        }
    }
    class Solution3 {
        public int destroyTargets(int[] nums, int space) {
            TreeMap<Integer,int[]> map=new TreeMap<>(Integer::compareTo);

            for (int i = 0; i < nums.length; i++) {
                int i1 = nums[i] % space;
                if (map.containsKey(i1)) {
                int[] ints = map.get(i1);
                    ints[1]=Math.min(nums[i],ints[i]);
                    ints[0]++;
                    map.put(i1,ints);
                }else{

                    map.put(i1,new int[]{1,nums[i]});
                }
            }
            int[] max = map.values().stream().max((a,b)->Integer.compare(a[0],b[0])).get();
            int min=Integer.MAX_VALUE;
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                if (entry.getValue()[0]==max[0]){
                    min=Math.min(entry.getValue()[1],min);
                }
            }
            return min;
        }
    }

    class Solution1 {
        public String oddString(String[] words) {
            int[] diff=new int[words[0].length()-1];
            int count=1;
            int diffs=0;
            String word1 = words[0];
            for (int i = 1; i < word1.length(); i++) {
                diff[i-1]=word1.charAt(i)-word1.charAt(i-1);
            }
            for (int i = 1; i < words.length; i++) {
                String word = words[i];
                if (isE(word,diff)) {
                    count++;
                    if (diffs!=0){
                        return words[diffs];
                    }
                }else{
                    if (count>1){
                        return words[i];
                    }else if (diffs==0){
                        diffs=i;
                    }else{
                        return words[0];
                    }
                }
            }
            return words[0];
        }
        public boolean isE(String word,int[] diff){
            for (int j = 1; j < word.length(); j++) {
                if (word.charAt(j)-word.charAt(j-1)!=diff[j-1]){
                    return false;
                }
            }
            return true;
        }
    }
}
