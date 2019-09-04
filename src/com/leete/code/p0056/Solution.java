package com.leete.code.p0056;

/**
 * 题目
 * 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2:

 输入: [[1,4],[4,5]]
 输出: [[1,5]]
 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

/**
 * 思路：1、先排序 ，然后比较每个元素的后边界 判断 区间是否重合
 */

/**
 * 领会：
 *  Arrays.sort，通过重写一个比较器，来自定义排序
 *  比较器：//返回负数，第一个参数<第二个参数
 *  返回0，第一个参数=第二个参数
 *  返回正数，第一个参数>第二个参数
 */

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> output = new ArrayList<>();
        int[][] outputArray = new int[output.size()][2];
        if(intervals.length==0)
            return output.toArray(outputArray);
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //返回负数，第一个参数<第二个参数
                //返回0，第一个参数=第二个参数
                //返回正数，第一个参数>第二个参数
                return o1[0]-o2[0];
            }
        });
        output.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] pre = output.get(output.size() - 1);

            if(pre[1]<curr[0]){//区间没有重合
                output.add(curr);
            }else {
                //区间重合了
                pre[1]=Math.max(curr[1],pre[1]);
            }
        }

        return output.toArray(outputArray);
    }

}
