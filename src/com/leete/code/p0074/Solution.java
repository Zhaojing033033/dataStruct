package com.leete.code.p0074;

/**
 * 题目
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 思路
 * <p>
 * 思路
 */

/**
 * 思路
 */

/**
 * 体会：
 *
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        return search(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean search(int[][] matrix, int target, int left, int right) {

        int col = matrix[0].length;
        int mid = (left + right) / 2;
        int mid_row = mid / col;
        int mid_col = mid % col;
        if(left == right)
            return  matrix[mid_row][mid_col]==target;

        if (target < matrix[mid_row][mid_col])
            return search(matrix, target, left, mid);
        else if(target > matrix[mid_row][mid_col])
            return search(matrix, target, mid+1, right);
        else
            return true;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20 },{23, 30, 34, 50}};
        int[][] matrix = {{1,1}};
        //int[][] matrix = {{1}, {3}};
        boolean b = new Solution().searchMatrix(matrix, 1);
        System.out.println(b);
    }

}
