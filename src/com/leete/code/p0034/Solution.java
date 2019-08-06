package com.leete.code.p0034;

/**
 * 题目：
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]
 *
 */

/**
 * 思路：二分查找。
 *
 */
/**
 * 体会：
 *
 */
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
            if(ret[0] ==-1 && ret[1]==-1)  //表示没有找到过一个target
                ret[0]=ret[1]=mid;
            if(mid>ret[1])  //表示新找到的target的下标大于ret[1]
                ret[1]=mid;
            else if(mid<ret[0])//表示新找到的target的下标小于ret[0]
                ret[0]=mid;
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
