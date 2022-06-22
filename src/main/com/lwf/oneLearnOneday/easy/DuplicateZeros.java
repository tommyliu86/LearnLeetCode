package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-17 11:24
 */
public class DuplicateZeros {
    //逆向操作，使用计数器，正向遍历进行模拟计数，找到当前在数组最后位置应该放置的是哪个index，从数组最后向前进行更新，这样就不需要每次把后面元素进行平移了。
    //只需要一次移动即可。
    class Solution1 {
        public void duplicateZeros(int[] arr) {

            int r=0;
            int l=0;
            while (r<arr.length){
                if (arr[l]==0){
                    r++;
                }
                l++;
                r++;
            }
            l--;
            if (r>arr.length){
                arr[arr.length-1]=0;
                l--;
                r=arr.length-1;
            }
            //r到达最后，l指向的就是要移动到r的元素
            while (r>0){

                    arr[--r]=arr[l];

                if (arr[l]==0){
                    arr[--r]=0;
                }
                l--;
            }

        }
    }
    //正向操作，每次找到0，都需要把后面的数进行移动，但这样的时间复杂度是 log(n)
    class Solution {
        public void duplicateZeros(int[] arr) {


            for (int i = 0; i < arr.length; i++) {
                int l = i;
                while (l < arr.length && arr[l] == 0) {
                    l++;
                }
                if (l == arr.length) {
                    break;
                }
                int zeroL = l - i;
                for (int j = 0; j < zeroL; j++) {
                    int temp = 0;
                    int newi = j + l;
                    while (newi < arr.length) {
                        int t = arr[newi];
                        arr[newi] = temp;
                        temp = t;
                        newi = newi + zeroL;
                    }
                }
                if (zeroL>0){

                    i = i + zeroL * 2 - 1;
                }
            }
        }
    }
}
