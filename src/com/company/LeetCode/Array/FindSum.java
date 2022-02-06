package com.company.LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class FindSum {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i=0;i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]).intValue();
                result[1] = i;
                return result;
            }
            map.put(target - nums[i], i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,-4,-5};
        int[] result = twoSum(arr, -8);
        System.out.println(result[0] + "," + result[1]);
    }

}
