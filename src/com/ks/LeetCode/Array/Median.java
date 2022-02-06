package com.ks.LeetCode.Array;

import java.util.Arrays;

public class Median {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] nums3 = new int[len1+len2];
        for(int i=0; i< len1; i++) {
            nums3[i] = nums1[i];
        }
        for(int i=0; i< len2; i++) {
            nums3[len1++] = nums2[i];
        }
        Arrays.sort(nums3);

        int len3 = nums3.length;

        if(len3 % 2 == 0 ) {
            int index1 = len3/2;
            int index2 = index1-1;
            System.out.println(nums3[index1]);
            System.out.println(nums3[index2]);
            return (nums3[index1] + nums3[index2])/2.0;
        }
        else {
            int index1 = len3/2;
            return nums3[index1];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
