package com.leete.code;


public class Solution {



    public int[] searchRange(int[] nums ,int target){
        int [] ret =new int[]{-1,-1};
        searchRange(nums,0,nums.length-1,ret,target);
        return ret;
    }

    public void searchRange(int[] nums ,int left,int right,int[] ret,int target){
        int mid =  (left+right)/2;

        if(nums[mid] == target){
            if(mid>=ret[1]){
                ret[0]=ret[1];
                ret[1]=mid;
            }else if( mid<= ret[1] && ret[0]==-1){
                ret[0]=mid;
            }else if(mid<=ret[0]){
                ret[0]=mid;
            }
            else {

            }
        }

        if(left == right)
            return ;

        if(target <= nums[mid] && target > nums[left]){
            searchRange(nums,left,mid,ret,target);
        }
        if(  target >= nums[mid] && target< nums[right]){
            searchRange(nums,mid+1,right,ret,target);
        }



        return ;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] aa= new int[]{1,2,3,3,3,4,4,5,6,6};
        int[] ints = solution.searchRange(aa, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
}
