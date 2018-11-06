package com.qihui.array;

import java.util.Arrays;


/**
 * @author chenqihui
 * @date 2018/11/6
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p=0, i=0, j=0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[p] = nums1[i];
                i++; j++; p++;
            }else if(nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }

        }
        return Arrays.copyOfRange(nums1, 0, p);
    }
}
