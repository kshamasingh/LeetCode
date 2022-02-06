package com.company.LeetCode;

import java.util.Stack;

public class Paypal {


    /*
    *
    * Question1: Remove braces and reverse string
Input1
{I{am{paypal}}}
{I{amlapyap}}
{Ipaypalma}
amlapyapI

Input 2
I{am{paypal}}
Ipaypalma

am ->paypal
amlapypa
Iapypalma
     */
/*
Stack: I -> am -> paypal

amlapypa
Iapypalma
     */


    public static String findOutputOfGivenInput(String str){
        Stack<String> stack = new Stack<>();
        String tempOut = "";
        for (int i =0; i<str.length();) {
            char charAt = str.charAt(i);
            if (charAt == '{') {
                i++;
            } else if (Character.isLetter(str.charAt(i))) {
                String temp = "";
                for (int j = i; j<str.length(); j++ ){

                    if (Character.isLetter(str.charAt(j)) )
                    {
                        System.out.println("str.charAt(j) : " + str.charAt(j));
                        temp += str.charAt(j);
                    } else {
                        i=j;
                        System.out.println("str.charAt(j)---> : " + str.charAt(j));
                        System.out.println("str.charAt(i)---> : " + str.charAt(i));
                        break;
                    }
                }
                System.out.println("Temp: " + temp);
                stack.add(temp);
                System.out.println("Stack: " + stack.peek());
                temp = "";
            }
            else if (!stack.isEmpty()) {
                    tempOut = stack.peek();
                    tempOut = reverse(tempOut);
                    System.out.println("tempOut : " + tempOut);
                    stack.pop();
                    stack.add(tempOut);
                }
            }
        return stack.peek();
    }

    private static String reverse(String s) {
        String temp = "";
        for (int i = s.length()-1; i>=0; i--) {
            temp += s.charAt(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(findOutputOfGivenInput("{I{am{paypal}}}"));
    }
}
