package com.leete.code.p0046;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]

 */

/**
 * 思路：回朔
 */


/**
 * 体会：
 * 1、没有领会回朔的精髓。想了很久没有思路
 * 2、由于是没有重复的数组，排列后，后然有这么多个元素。所以可以 直接在这个数组上通过交换位置进行排列
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3};
        List<List<Integer>> permute = new Solution().permute(data);
        permute.forEach(item -> {
            System.out.println("");
            item.forEach(subItem -> {
                System.out.print(subItem + " ");
            });
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permute(nums,new ArrayList<Integer>(), output);
        return output;
    }

    public void permute(int[] nums, List<Integer> input, List<List<Integer>> output) {
        //若排列数  排完，则将这个排列入到output中
        if (input.size() == nums.length){
            output.add(new ArrayList<>(input));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!input.contains(nums[i])){//若这个 数在input中没有，则加入input中，并进行递归。在加朔时，将该数移出
                input.add(nums[i]);
                permute(nums, input, output);
                input.remove(input.size()-1);
            }
        }
    }


    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }
}
