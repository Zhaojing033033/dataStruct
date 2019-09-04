package com.leete.code.p0055;

/**
 * 题目
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 思路
 */

/**
 * 思路:
 */

/**
 * 体会：
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{0};
        boolean b = new Solution().canJump(data);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {
        return nextPosition(nums,0,nums[0]);
    }

    /**
     * 解法超时
     * @param nums
     * @param start
     * @param maxStep
     * @return
     */
    public boolean nextPosition(int[] nums, int start, int maxStep) {
        //若start已经到了最后个元素，返回true
        if(start==nums.length-1)
            return true;
        //若start没有到达最后个元素，且最大步数为为0，则还能再继续向下跳，返回false。
        if(maxStep== 0)
            return false;

        for (int i = maxStep; i > 0; i--) {
            //
            int nextIndex = start + i;
            //若下一步没有超出数组长度，则进行递归
            if(nextIndex>=nums.length)
                continue;
            boolean b = nextPosition(nums, nextIndex, nums[nextIndex]);
            //下一步返回结果为true，则能达到。返回false，则对maxStep-1进行尝试
            if(b==true)
                return true;

        }
        return false;
    }
}
