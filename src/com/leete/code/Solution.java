package com.leete.code;


public class Solution {



    public int[] searchRange(int[] nums ,int target){

        int [] ret =new int[]{-1,-1};
        if(nums.length==0) return ret;
        searchRange(nums,0,nums.length-1,ret,target);
        return ret;
    }

    public void searchRange(int[] nums ,int left,int right,int[] ret,int target){
        int mid =  (left+right)/2;
        if(nums[mid] == target){//若中间数==target
            if(mid>=ret[1]){//将中间数的下标与找到的下标比较， 大于等于，则ret[1]=mid
                if(ret[0]==-1 && ret[1]==-1){
                    ret[0]=mid;
                    ret[1]=mid;
                }
                ret[1]=mid;
            }else if( mid< ret[1] && ret[0]==-1){// mid<= ret[1] && ret[0]==-1(表示ret[0]没有被赋值过)
                ret[0]=mid;
            }else if(mid<=ret[0]){//mid<=ret[0]  表示，ret[0]赋值过，但是找到一个左边的target的下标
                ret[0]=mid;
            }
        }

        if(left == right)//若left == right，表示已经不能再继续二分了。当前分支退出
            return ;

        if(target <= nums[mid] && target >= nums[left]){//表示target在左边还有，进行递归
            searchRange(nums,left,mid,ret,target);
        }
        if(  target >= nums[mid] && target<= nums[right]){//表示target在右边边还有，进行递归
            searchRange(nums,mid+1,right,ret,target);
        }
        return ;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] aa= new int[]{3};
        int[] ints = solution.searchRange(aa, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
}
