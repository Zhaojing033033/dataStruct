package com.leete.code.p0079;

import com02.linked.list.LinkedList;

/**
 * 题目
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */

/**
 * 时间复杂度和空间复杂度 都比leetcode上的精选解题差很多
 */
public class Solution {
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int[][] flag = new int[board.length][board[0].length];

        for (int i = 0; i < flag.length; i++)
            for (int j = 0; j < flag[i].length; j++)
                flag[i][j] = 0;

        boolean found = false;
        for (int i = 0; i < flag.length; i++){
            for (int j = 0; j < flag[i].length; j++){
                found =backup(new LinkedList(), flag, i, j);
                if (found)
                    return true;
            }
        }


        return found;
    }

    public boolean backup(LinkedList<Character> list, int[][] flag, int row, int col) {
        boolean found = false;
        if (row >= board.length
                || row < 0
                || col >= board[0].length
                || col < 0
                || flag[row][col] == 1
                || list.size() >= word.length())
            return false;

        char charAt = word.charAt(list.size());


        if (board[row][col] == charAt && list.size()+1==word.length())
            return true;
        else if(board[row][col] != charAt)
            return false;

        flag[row][col] = 1;

        list.addLast(board[row][col]);

        if (!found)
            found = backup(list, flag, row + 1, col);
        if (!found)
            found = backup(list, flag, row - 1, col);
        if (!found)
            found = backup(list, flag, row, col + 1);
        if (!found)
            found = backup(list, flag, row, col - 1);

        flag[row][col] = 0;
        list.removeLast();

        return found;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        //String word="ABCCED";
        //String word="ABCB";
        String word="ABCESEEDASFC";
        boolean exist = new Solution().exist(board, word);
        System.out.println(exist);
    }
}
