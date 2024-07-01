package com.lwf.oneLearnOneday.normal;

import java.sql.SQLOutput;
import java.util.*;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new nextGreaterElement3().nextGreaterElement(1999999999));
    }
    /**
     * 556. 下一个更大元素 III
     * 从低位向高位移动更大的数字？如果低位上的某个数字比高位上的大，则移动低位数字到这个位置，且这个位置往后的所有数字升序排列
     * 相当于分成了两部分
     * 类型转换，一定要注意。。
     *
     */
    static
    class nextGreaterElement3 {
        public int nextGreaterElement(int n) {
            List<Integer> list=new ArrayList<>();
            boolean find=false;
            long i=1;
            int cur=0;
            while (n!=0){
                i*=10;
                cur = n % 10;
                n/=10;
                //低位比高位的数字大，则可以计算
                if (list.size()!=0&& list.get(list.size()-1)>cur){
                    find=true;

                    //找到第一个比cur大的数
                    int i1=list.size()-1;
                   while (i1>=0&&list.get(i1)>cur){
                       i1--;
                   }
                    int temp=list.get(i1+1);
                    list.set(i1+1,cur);
                    cur=temp;
                    break;
                }
                list.add(cur);
            }
            if (!find){
                return -1;
            }
            list.sort(Integer::compareTo);

            long rtn=n*i+cur*(i/10);

            i=0;
            for (int j = list.size() - 1; j >= 0; j--) {
              rtn+=(int)(list.get(j)*(Math.pow(10,i++)));

            }
            return rtn>Integer.MAX_VALUE?-1:(int) rtn;
        }
    }
    /**
     * 496. 下一个更大元素 I
     * 单调栈+hash，
     */
    class nextGreaterElements1 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer,Integer> map=new HashMap<>();
            int[] ans=new int[nums1.length];
            Stack<Integer> stack=new Stack<>();

            for (int i = 0; i < nums2.length; i++) {
                while (!stack.isEmpty()&&stack.peek()<nums2[i]){
                    map.put(stack.pop(),nums2[i]);
                }
                stack.push(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                ans[i]=map.getOrDefault(nums1[i],-1);
            }
            return ans;
        }
    }

    /**
     * 503. 下一个更大元素 II
     * 单调递减栈，对数组进行两次入栈，找到重合的下标或者是两次都入栈完成
     */
    class nextGreaterElements2 {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();

            int[] ans = new int[nums.length];
            Arrays.fill(ans, -1);
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    Integer pop = stack.pop();
                    ans[pop] = nums[i];
                }
                stack.push(i);
            }
            for (int i = 0; !stack.isEmpty() && stack.peek() > i && i < nums.length; i++) {

                while (!stack.isEmpty() && stack.peek() > i && nums[i] > nums[stack.peek()]) {
                    Integer pop = stack.pop();
                    ans[pop] = nums[i];
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int nextGreaterElement(int n) {
            String strN = String.valueOf(n);
            char[] chars = strN.toCharArray();
            int i = chars.length - 1;
            while (i >= 0 && chars[i - 1] >= chars[i]) {
                i--;
            }
            if (i < 0) {
                return -1;
            }
            int j = i + 1;
            while (j < chars.length && chars[j] > chars[i]) {
                j++;
            }
            j--;
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            Arrays.sort(chars, i + 1, chars.length);
            int r = 0;
            for (int k = 0; k < chars.length; k++) {
                if ((r * 10 > Integer.MAX_VALUE / 10) || (r * 10 == Integer.MAX_VALUE / 10 && chars[k] - '0' > Integer.MAX_VALUE % 10)) {
                    return -1;
                }
                r = r * 10 + chars[k] - '0';
            }
            return r;
        }
    }
}
