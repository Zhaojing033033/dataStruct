package com.leete.code.p0064;

/**
 * 题目
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 */

/**
 * 思路:
 * 回朔：时间超时
 * 回朔+记忆化搜索
 * 二维动态规划 ：
 *      动态方程
 *      ints[i][j] = Math.min(ints[i][j - 1] , ints[i - 1][j]) + grid[i][j];
 *       ints[i][j] = ints[i][j - 1] + grid[i][j];
 *       ints[i][j] = ints[i][j - 1] + grid[i][j];
 *一维动态规划：
 *      动态方程：
 *      dp(j)=grid(i,j)+min(dp(j),dp(j+1))
 * 由于 是按行遍历的，所以只需要有一个一维数组存储即可。
 * 遍历每行，计算dp（j）的数值后，会覆盖上一行计算的值。
 * 所以每个元素（i）（j）计算所需要的下面和右面的两个值都可以同时取到
 *
 * 直接使用原数组进行动态规划
 *
 *      */

/**
 * 体会：
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[][] ints = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = new Solution().minPathSum1(ints);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ints = new int[row][col];
        ints[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    continue;
                else if (i == 0)
                    ints[i][j] = ints[i][j - 1] + grid[i][j];
                else if (j == 0)
                    ints[i][j] = ints[i - 1][j] + grid[i][j];
                else
                    ints[i][j] = Math.min(ints[i][j - 1] , ints[i - 1][j]) + grid[i][j];
            }
        }
        return ints[row - 1][col - 1];
    }

    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    continue;
                else if (i == 0)
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0)
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                else
                    grid[i][j] = Math.min(grid[i][j - 1] , grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[row - 1][col - 1];
    }
}
