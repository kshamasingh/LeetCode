package com.ks.LeetCode.String;

import java.util.Arrays;
import java.util.List;

public class RemVowel {

    public static String remVowel(String str) {
        Character character[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I','O','U'};

        List<Character> list = Arrays.asList(character);
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println(stringBuffer);

        for (int i=0;i<stringBuffer.length();i++) {
            if (list.contains(stringBuffer.charAt(i))) {
                stringBuffer.replace(i, i+1, "");
                i--;
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(remVowel("welcome to geeksforgeeks"));
    }
}
