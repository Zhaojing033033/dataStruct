package com.leete.code.p0075;

/**
 * 题目
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：
 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？

 */
/**
 * 思路 ：
 * 1、使用桶排序（堆排序？）
 * 2、使用三指针
 */

public class Solution {
    public void sortColors(int[] nums) {
        int left =0,curr=0,right=nums.length-1;
        while (curr<=right){
            if(nums[curr]== 2 ){//curr==2,向右边移动
                trans(nums,right,curr);
                right--;
            }
            else if(nums[curr]== 0){//curr==0,向左边移动
                trans(nums,left,curr);
                left++;
                curr++;
            }else{//==1 不动，变curr
                curr++;
            }

        }
    }

    public void trans(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    public static void main(String[] args) {
        //int[] ints = {2,0,1};
        //int[] ints = {1,2,2};
        int[] ints = {2, 0, 2, 1, 1, 0};
        new Solution().sortColors(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}
