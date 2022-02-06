package com.ks.LeetCode.Array;

import java.util.Arrays;

public class mergeArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int j=0;
        for (int i=0; i<nums1.length;i++) {
            if (nums1[i] != 0)
                result[j++] = nums1[i];
        }
        for (int i=0; i<nums2.length;i++) {
            if (nums2[i] != 0)
                result[j++] = nums2[i];
        }
        Arrays.sort(result);
        for (int k=0;k<m+n;k++){
            System.out.print(result[k]);
            System.out.print(",");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr,3,arr2, 3);

    }
}
