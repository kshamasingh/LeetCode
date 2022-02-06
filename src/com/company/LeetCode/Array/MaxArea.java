package com.company.LeetCode.Array;

import java.util.Arrays;

public class MaxArea {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        Arrays.sort(nums);
        for (int i = 0; i + k < nums.length; i++) {
            for (int j = i+1; j < i+k; j++) {
                System.out.println(Math.abs(nums[j] - nums[i]));
                if (Math.abs(nums[j] - nums[i]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {-2147483648,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1, 1));
    }
}
