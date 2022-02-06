package com.ks.LeetCode.Bit;

public class BitOperator {

    public static int concatenatedBinary(int n) {

        long ans = 0;
        int digits = 0;
        int mod = 1_000_000_007;

        for (int num = 1; num <= n; num++) {
            System.out.println("num: " + num);
            if ((num & (num - 1)) == 0) {
                System.out.println("digits: " + digits);
                ++digits;
            }
            System.out.println("Previous ans: " + ans);
            long shift = ans << digits | num;
            System.out.println("Shift Value: " + shift);
            long shift_with_num = shift | num;
            System.out.println("shift_with_num : " + shift_with_num);
            ans = shift % mod;
            System.out.println("Next ans: " + ans);
        }
        System.out.println("Final ans: " + ans);
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(concatenatedBinary(3));
    }
}
