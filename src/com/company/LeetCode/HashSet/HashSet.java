package com.company.LeetCode.HashSet;


import javax.swing.plaf.IconUIResource;

public class HashSet {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n >> 2;
            System.out.println(count++ + ": " + n);
        }
        return count;
    }

    public static int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int minCost = 0;
        int pre = 0;
        if (n == 2)
            return min(cost[0], cost[1]);
        if (n > 2) {
            for (int i = 0; i < cost.length - 1; ) {
                if (cost[i] > pre) {
                    minCost = minCost - pre;
                    i--;

                }
                if (cost[i] < cost[i + 1]) {
                    minCost += cost[i];
                    pre = cost[i + 1];
                    i = i + 2;
                } else {
                    minCost += cost[i + 1];
                    i++;
                }
            }

        }
        return minCost;
    }

    private static int min(int a, int b) {
        if (a > b)
            return b;
        return a;
    }

//    public static void main(String[] args) {
////        hammingWeight(100);
////        System.out.println(tribonacci(4));
//        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
//    }


    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        // Root of Binary Tree
        Node root;

        BinaryTree() {
            root = null;
        }

        /* Given a binary tree, print its nodes according to the
          "bottom-up" postorder traversal. */
        static int printPostorder(Node node, int low, int high) {
            if (node == null)
                return 0;
            int count = 0;
            if (node.key >= low && node.key <= high) {
                count += node.key;
                // now deal with the node
                System.out.print(node.key + " ");
//            }
                // first recur on left subtree
                count += printPostorder(node.left, low, high);

                // then recur on right subtree
                count += printPostorder(node.right, low, high);
            }
            return count;
        }

        // Wrappers over above recursive functions

        // Driver method
        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(10);
            tree.root.left = new Node(5);
            tree.root.right = new Node(15);
            tree.root.left.left = new Node(3);
            tree.root.left.right = new Node(7);
            tree.root.right.right = new Node(18);
            System.out.println("\nPostorder traversal of binary tree is ");
//            System.out.println("COUNT: " + printPostorder(tree.root,7, 15)); }
//            preorder(tree.root);


        }

        static void preorder(Node root, int[] order, int index) {
            order[index++] = root.key;
            preorder(root.left, order, index);
            preorder(root.right, order, index);
        }
    }
}


