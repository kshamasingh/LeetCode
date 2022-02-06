package com.company.LeetCode.String;

import java.util.*;
import java.util.stream.IntStream;

public class FinalValueAfterOperations {

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (int i=0;i<operations.length;i++) {
            if (operations[i].startsWith("-") || operations[i].endsWith("-"))
                x -= 1;
            else
                x += 1;
        }
        return x;
    }

    public static int mostWordsFound_brute_force(String[] sentences) {

        int count = 0;
        int max_count =0;

        for (int i=0; i< sentences.length;i++){
            StringBuffer stringBuffer = new StringBuffer(sentences[i]);
            for (int j=0; j<stringBuffer.length(); j++) {
                if((stringBuffer.charAt(j)) == ' '){
                    count++;
                }
            }
            if (count>max_count)
                max_count = count;
            count = 0;
        }
        return max_count+1;
    }

    public static int mostWordsFound(String[] sentences) {
        int max_count =0;
        int length = 0;
        int max_length = 0;
        int max_sentences_index = 0;


        for (int i=0; i< sentences.length;i++) {
            length = sentences[i].length();
            if (length > max_length) {
                max_length = length;
                max_sentences_index = i;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(sentences[max_sentences_index]);
        for (int j=0; j<stringBuffer.length(); j++) {
            if((stringBuffer.charAt(j)) == ' '){
                max_count++;
            }
        }
        return max_count+1;
    }

    public static String defangIPaddr(String address) {
        StringBuffer stringBuffer = new StringBuffer(address);
        String temp = "";
        for (int i=0;i<stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '.') {
                temp += "[.]";
            }
            else {
                temp += String.valueOf(stringBuffer.charAt(i));
            }
        }
        return temp;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        List<Character> list = new ArrayList<>();
        for (char ch : jewels.toCharArray()) {
            list.add(ch);
        }
        int count =0;
        StringBuffer stringBuffer = new StringBuffer(stones);
        for (int i=0; i< stringBuffer.length(); i++) {
            if (list.contains(stringBuffer.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static String restoreString(String s, int[] indices) {
            char[] characters = s.toCharArray();
            char[] arr = new char[characters.length];
            String temp = "";
            for (int i=0; i < indices.length; i++) {
                arr[indices[i]] = characters[i];
            }
        for (int i=0; i < arr.length; i++) {
            temp += arr[i];
        }
            return temp;
    }

    public static int balancedStringSplit(String s) {
        char[] characters = s.toCharArray();
        int rcount = 0;
        int lcount = 0;
        int count = 0;
        for (int i=0; i < characters.length; i++) {
            if (characters[i] == 'R')
                rcount++;
            if (characters[i] == 'L')
                lcount++;
            if (rcount == lcount) {
                count++;
                rcount = 0;
                lcount = 0;
            }
        }
        return count;
    }

    public static int countPoints(String rings) {
        var ringsByRod = new HashMap<Integer, Set<Character>>();

        IntStream.iterate(0, i -> i + 1 < rings.length(), i -> i + 2)
                .forEach(i -> ringsByRod.computeIfAbsent(rings.charAt(i + 1) - '0', k -> new HashSet<>())
                        .add(rings.charAt(i)));

        return (int) ringsByRod.values()
                .stream()
                .filter(colors -> colors.size() == 3)
                .count();
    }

    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static String truncateSentence(String s, int k) {
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer newStr = new StringBuffer();
        int count =0;
        for (int j=0; j<stringBuffer.length(); j++) {
            if((stringBuffer.charAt(j)) == ' '){
                count++;
            }
            if (count == k)
                break;
            newStr.append(stringBuffer.charAt(j));
        }
        return newStr.toString();
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        int count = 0;
        String temp = "";
        for (int i=0; i<words.length; i++) {
            StringBuffer stringBuffer = new StringBuffer(words[i]);
            for (int j=0; j<stringBuffer.length(); j++) {
                temp += morse[stringBuffer.charAt(j) - 'a'];
            }
           set.add(temp);
            temp = "";
        }
        return set.size();
    }

    public static void main(String[] args) {
//        System.out.println(finalValueAfterOperations({"X++","++X","--X","X--"}));
//        System.out.println(mostWordsFound({"please wait", "continue to fight", "continue to win"}));
//        System.out.println(defangIPaddr("255.100.50.0"));
//        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
//        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,1,2,3}));
//        System.out.println(countPoints("B0B6G0R6R0R6G9"));
//        System.out.println(toLowerCase("KSHAMA"));
//        System.out.println(truncateSentence("What is the solution to this problem", 4));
        String[] strings = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(strings));
    }
}
