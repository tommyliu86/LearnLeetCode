package com.lwf;

/**
 * author Administrator
 * time 2019-07-24
 */
public class Rotate {
    /**
     * 1.求k除nums.length的余数，为nums的元素的步进数
     * 2.遍历数组，进行步进移动。
     * 3.停止条件1.计数器，每进行一次交换++，count=length时停止
     * 4.循环判断的边界条件
     * @param nums
     * @param k
     */
    public  void  rotate(int[] nums, int k){
        k=k%nums.length;
        int count=0;
        for (int i = 0; count < nums.length; i++) {
           int cursor=(i+k)%nums.length;
           int temp=nums[i];
            int tt;
            while (cursor!=i){
               tt=nums[cursor];
                nums[cursor]=temp;
                temp=tt;
                cursor=(k+cursor)%nums.length;
                count++;
            }
            nums[cursor]=temp;
            count++;

        }

    }

    /**
     * 1.while循环一般需要设置前置条件，可以使用dowhile启动
     * 2.dowhile和while的区别。执行在前还是判断在前！
     * @param nums
     * @param k
     */
    public  void  rotate1(int[] nums, int k){
        k=k%nums.length;
        int count=0;
        for (int i = 0; count < nums.length; i++) {
            int cursor=i;
            int temp=nums[i];
            do {
                cursor=(cursor+k)%nums.length   ;
                int nextk=nums[cursor];
                nums[cursor]=temp;
                temp=nextk;
            }while (cursor!=i);

        }

    }
}
