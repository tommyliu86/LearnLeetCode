package com.lwf.week;

import java.util.*;

public class Week2132 {

    class Solution4 {
        public int maximumLength(int[] nums, int k) {
            int n = nums.length;
            //三维数组，i表示当前元素为end的子数组，j表示当前i为尾巴的子数组中，不同k的最大长度， k=0，表示没有取当前元素，k=1表示取了当前元素，
            int[][][] dp = new int[n + 1][k + 2][2];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k + 1; j++) {
                    //不取当前，因此，z=0，可以是前面一个的取和不取的最大值，
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1]);
                    //取当前，则需要再考虑，前一个结尾的当前k-1的数据情况，为什么呢？我们的k-1的这种情况已经动态规划过了，这里要放的是子数组中拥有k个的情况， 因此我们直接取j-1！！！
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + 1;

                    //获取上一次当前i的元素出现的index的位置，因为我们需要考虑，当前不同元素个数不变的时候，也就是相同元素上一次出现的位置。！！！
                    Integer index = map.get(nums[i - 1]);
                    if (index == null) {
                        continue;
                    }
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[index + 1][j][1] + 1);
                }
                map.put(nums[i - 1], i - 1);
            }
            return Math.max(dp[n][k + 1][0], dp[n][k + 1][1]);
        }
    }

    /**
     * dp动态规划，三维数组，i表示当前的元素，j表示当前元素为结尾的子数组中，真正的尾巴 是哪个，k表示当前的子数组中有多少对不重复数据，
     * 这个dp动态规划，在小数据中可以解，但是第四题会爆内存。
     */
    class Solution31{
        public int maximumLength(int[] nums, int k) {
            int n = nums.length;

            int[][][] dp = new int[n + 1][n + 1][k + 2];
            int result = 0;

            for (int i = 0; i < n; i++) {
                int num = nums[i];
                for (int j = 0; j < i; j++) {
                    for (int x = 0; x <= k; x++) {
                        // 不选择当前元素
                        dp[i][j][x] = dp[i - 1][j][x];
                        // 选择当前元素,如果尾巴相等。k不会变化，直接变长。
                        if (nums[j] == num) {
                            dp[i][i][x] ++;
                            result = Math.max(result, dp[i][i][x]);
                        }else{//尾巴不相等，则 k会变化，因此，长度变长的时候，下一个也会变
                            dp[i][i][x+1]=Math.max(dp[i][i][x+1],dp[i][j][x]+1 );
                            if (x+1<=k){

                                result = Math.max(result, dp[i][i][x+1]);
                            }
                        }
                    }
                }
            }

            return result;
        }
    }
    /**
     * 最多允许有k个相邻i和i+1不相等，也就是i和i+1的值必须相等
     * 递归遍历？
     */
    class Solution3 {
        public int maximumLength(int[] nums, int k) {
            return recurse(nums,0,k,0,new ArrayList<>());
        }
        public int recurse(int[] nums,int i,int k,int curK,List<Integer> list){
            if (i==nums.length){
                return list.size();
            }
            int max=0;
            if (list.size()>0&& nums[i]!=list.get(list.size()-1)){
               if (curK==k){
                max= Math.max(max,  recurse(nums,i+1,k,curK,list));
               }else{
                   max=Math.max(max, recurse(nums,i+1,k,curK,list));
                   list.add(nums[i]);
                   max=Math.max(max, recurse(nums,i+1,k,curK+1,list));
                   list.remove(list.size()-1);
               }
            }else{

                list.add(nums[i]);
                max=Math.max(max, recurse(nums,i+1,k,curK,list));
                list.remove(list.size()-1);
            }
            return max;
        }
    }

    class Solution2 {
        /**
         * 直接模拟 冒泡排序。
         * @param skills
         * @param k
         * @return
         */
        public int findWinningPlayer(int[] skills, int k) {

            if (k>=skills.length){
                int max=skills[0],z=0;
                for (int i = 1; i < skills.length; i++) {
                    if (max>skills[i]){
                        continue;
                    }else{
                        max=skills[i];
                        z=i;
                    }
                }
                return z;
            }
            Queue<Integer> queue=new LinkedList<>();
            int win=0,i=-1;
            for (int j = 0; j < skills.length; j++) {
                queue.add(j);
            }
            while (win<k){
                if (win==0){
                    Integer i1 = queue.poll();
                    Integer i2 = queue.poll();
                    if (skills[i1]>skills[i2]){
                        i=i1;
                        queue.add(i2);
                    }else{
                        i=i2;
                        queue.add(i1);
                    }
                        win=1;

                }else{
                    Integer i3 = queue.poll();
                    if (skills[i]>skills[i3]){
                        win++;
                        queue.add(i3);
                    }else{
                        win=1;
                        queue.add(i);
                        i=i3;
                    }
                }
            }
            return i;

        }
    }
    class Solution1 {

        public String clearDigits(String s) {
            List<Character> list=new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)>='0'&&s.charAt(i)<='9') {
                    if (list.size()>0){
                        list.remove(list.size()-1);
                    }
                }else{
                    list.add(s.charAt(i));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
            }
            return stringBuilder.toString();
        }
    }
}
