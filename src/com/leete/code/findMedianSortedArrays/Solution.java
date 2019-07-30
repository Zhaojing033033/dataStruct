package com.leete.code.findMedianSortedArrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

 */

/**
 * 体会：1：判断积偶数；2：迭代存储
 *
 * 优化：每次只排除了一个，可以考虑一次排除 length/2
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int start1 = nums1.length;
        int start2 = nums2.length;
        int len = start1 + start2;
        int moveNum = (start1 + start2) / 2 + 1;

        int left = -1, right = -1;

        while (moveNum > 0) {
            right = left;
            if (start1 > 0 && (start2 <= 0 || nums1[start1-1] > nums2[start2-1])) {
                left = nums1[start1 - 1];
                start1--;
            } else {
                left = nums2[start2 - 1];
                start2--;
            }
            moveNum--;
        }
        if ((len & 1) == 0) {//偶数
            return (left + right) / 2.0;
        } else {
            return left;
        }
    }


    public static void main(String[] args) {

        int[] nums1 = {}, nums2 = {2, 3};
        //int [] nums1 = {},nums2 = {1};
        //int [] nums1 = {1, 2}, nums2 = {3, 4};
        //int [] nums1 = {1, 3},nums2 = {2};
        double medianSortedArrays = new Solution().findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }
}
