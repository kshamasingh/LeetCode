package com.company.LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class Intersection {
    public static int[] intersect(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
        List<Integer>list = new ArrayList<>();
            for (int i=0; i<len1; i++) {
                for (int j=0;j<len2; j++) {
                    if (nums1[i] == nums2[j]) {
                        {
                            list.add(nums1[i]);
                            nums2[j] = Integer.MIN_VALUE;
                            nums1[i] = Integer.MIN_VALUE;
                            break;
                        }
                    }
                }
            }
        int[] output = new int[list.size()];
            for (int i=0; i<list.size();i++)
                output[i] = list.get(i);

            return output;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        int[] arr2 = {2,2};
        intersect(arr,arr2);
    }
}
