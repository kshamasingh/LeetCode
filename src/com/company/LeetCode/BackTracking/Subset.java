package com.company.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
        public static int subsetXORSum(int[] nums) {
            int xorOut = 0;
            int finalXor = 0;
            List<List<Integer>> output = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            subset(output, current, nums, 0);
            for(int i=0; i<output.size();i++) {
                for(int j=0; j<output.get(i).size(); j++) {
                    xorOut = (xorOut ^ output.get(i).get(j));
                }
                finalXor += xorOut;
                xorOut = 0;
            }
            return finalXor;
        }

        public static void subset(List<List<Integer>> output, List<Integer> current, int[] nums, int index){
            if(index == nums.length)
            {
                output.add(current);
                System.out.print(current);
                return;
            }
            subset(output, new ArrayList<>(current), nums, index+1);
            current.add(nums[index]);
            subset(output, new ArrayList<>(current), nums, index+1);

        }


    public static List<String> letterCasePermutation(String s) {
            List<String> list = new ArrayList<>();
            permutation(list, s.toCharArray(), 0);
            return list;
    }

    public static void permutation(List<String> list, char[] c, int index){
            list.add(new String(c));
            for(int i=index; i<c.length; i++){
                if (Character.isLetter(c[i]))
                {
                    swap(c, i);
                    permutation(list, c, i+1);
                    swap(c, i);
                }
            }

    }

    public static void swap(char[] c, int i){
            char ch = c[i];
          c[i] = Character.isLowerCase(ch)?Character.toUpperCase(ch):Character.toLowerCase(ch);

    }

    public static void main(String[] args) {
//        System.out.println(subsetXORSum(new int[] {3,4,5,6,7,8}));
        System.out.println(letterCasePermutation("a1b1"));
    }
    }
