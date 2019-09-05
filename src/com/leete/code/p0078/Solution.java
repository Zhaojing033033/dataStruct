package com.leete.code.p0078;

import java.awt.BasicStroke;
import java.io.OutputStream;

/**
 * 题目
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]
 */

/**
 * 思路
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 体会：
 */
public class Solution {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backup(nums, 0, new LinkedList<>());
        return output;
    }

    public void backup(int[] nums, int index, LinkedList<Integer> temp) {
        output.add(new ArrayList(temp));
        if (index == nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            //output.add(new ArrayList(temp));
            backup(nums, i + 1, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> subsets = new Solution().subsets(ints);
        for (int i = 0; i < subsets.size(); i++) {
            for (Integer integer : subsets.get(i)) {
                System.out.print(integer + "  ");
            }
            System.out.println("");
        }
    }
}
