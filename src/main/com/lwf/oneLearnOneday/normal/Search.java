package com.lwf.oneLearnOneday.normal;

/**
 * author Administrator
 * time 2019-09-27-22:49
 * {@link 33.md}
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(new com.lwf.TOP100.normal.Search().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        return binarySearch (nums,0,nums.length-1,target);
    }
    int binarySearch(int[] nums,int left,int right,int target){
        if (left>=right) return target==nums[left]?left:-1;
        if (nums[left]>nums[right]){

            if (target>=nums[left]||target<=nums[right]){
              int mid=(left+right)/2;
              if (nums[mid]==target) return mid;
              else{
                  int rtn=binarySearch(nums,left,mid-1,target);
                  if (rtn==-1){
                      return  binarySearch(nums,mid+1,right,target);
                  }
                  else{
                      return rtn;
                  }
              }
            }
            else{
                return -1;
            }
        }else{
            if (target>=nums[left]&&target<=nums[right]){
                int mid=(left+right)/2;
                if (nums[mid]==target) return mid;
                else{
                    int rtn=binarySearch(nums,left,mid-1,target);
                    if (rtn==-1){
                        return  binarySearch(nums,mid+1,right,target);
                    }
                    else{
                        return rtn;
                    }
                }
            }else{
                return -1;
            }
        }
    }
}
