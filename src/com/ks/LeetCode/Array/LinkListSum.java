package com.ks.LeetCode.Array;

public class LinkListSum {


//      Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int ll1 = lengthLl(l1);
            int ll2 = lengthLl(l2);
            int sum = 0;
            int carry = 0;
            if(ll1>=ll2) {
                return getListNode(l1, l2, carry);
            } else {
                return getListNode(l2, l1, carry);
            }
        }

        public static ListNode getListNode(ListNode l1, ListNode l2, int carry) {
            int sum;
            while (l2.next != null) {
                sum = l1.val + l2.val;
                int currCarry = sum % 10;

                l1.val = sum / 10 + carry;
                carry = currCarry;
                l1 = l1.next;
                l2 = l2.next;
            }
            l1.val += carry;
            return l1;
        }

        public static int lengthLl(ListNode listNode) {
            int len = 0;
            while (listNode.next != null) {
                len ++;
            }
            return len;
        }

        public static void print(ListNode l1) {
            while (l1.next != null) {
                System.out.println(l1.val);
                l1 = l1.next;
            }
        }

        public static void main(String[] args) {

            ListNode l1 = new ListNode();
            l1.val = 1;
//            l1.next.val = 2;
//            l1.next.next.val = 3;

            ListNode l2 = new ListNode();
            l2.val = 1;
//            l2.next.val = 2;
//            l2.next.next.val = 3;

            ListNode listNode = addTwoNumbers( l1, l2);
            print(listNode);
        }


    }

}
