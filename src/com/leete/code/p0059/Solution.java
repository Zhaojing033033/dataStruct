package com.leete.code.p0059;

/**
 * 题目
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

 示例:

 输入: 3
 输出:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */

/**
 * 思路:
 *  思路同56号题
 *  1、模拟螺旋的过程
 *  2、按层循环
 */

/**
 * 体会：
 *
 */
public class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        if(n==0)
            return matrix;
        int i=1;
        int t=0,l=0,r=matrix[0].length-1,b=matrix.length-1  ;//需要遍历的上左历左下四个边界
        int row=0,col=0;//行列的指针
        int redirct=0;//指针移动方向。0，1，2，3。0：向右。1：向下。2：向左。3：向上
        while (t<=b && l<=r){
            matrix[row][col]=i++;
            //变换方向  //缩小边界
            if(col == r && redirct==0){//向右移动，并且移动到边界时，变换方向为向下，且上边界下移
                redirct=(redirct+1)%4;//变换方向
                t++;//缩小边界
            }
            else if (row == b && redirct ==1){ //向下移动，并且移动到边界时，变换方向为左，且右边界左移
                redirct=(redirct+1)%4;
                r--;
            }
            else if(col==l && redirct==2) {//向左移动，并且移动到边界时，变换方向为右，且下边界上移
                redirct=(redirct+1)%4;
                b--;
            }
            else if(row == t && redirct==3){//向上移动，并且移动到边界时，变换方向为右，且左边界右移
                redirct=(redirct+1)%4;
                l++;
            }
            //移动指针，根据不同方向，不同的移动
            if(redirct==0){
                col++;
            }
            else if(redirct==1){
                row++;
            }
            else if(redirct==2){
                col--;
            }
            else if(redirct==3){
                row--;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println("");
        }
    }
}
