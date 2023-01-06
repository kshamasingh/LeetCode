package com.ks.LeetCode.Tree.BST;

import java.util.Scanner;

public class BinarySearchTree{
    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    static Node insertNewNode(Node root, int data){
        if (root == null)
            return newNode(data);
        if (root.data < data)
            root.left = insertNewNode(root.left, data);
        else
            root.right = insertNewNode(root.right, data);
        return root;
    }

    static void printInOrderTree(Node root) {
        if (root!=null) {
            printInOrderTree(root.left);
            System.out.print(root.data + ", ");
            printInOrderTree(root.right);
        }
    }

    static void printPreOrderTree(Node root) {
        if (root!=null) {
            System.out.print(root.data + ", ");
            printPreOrderTree(root.left);
            printPreOrderTree(root.right);
        }
    }

    static void printPostOrderTree(Node root) {
        if (root!=null) {
            printPostOrderTree(root.left);
            printPostOrderTree(root.right);
            System.out.print(root.data + ", ");
        }
    }

    static Node deleteLeafNode(Node node) {
        if (node == null)
            return null;
        if (node.left == null && node.right == null)
            return null;
        deleteLeafNode(node.left);
        deleteLeafNode(node.right);
        return node;
    }

    static Node searchNode(Node root, int key) {
        if (root == null || root.data == key)
            return root;
        if (root.data < key)
            return searchNode(root.right, key);
        return searchNode(root.left, key);
    }


    public static void main(String[] args) {
        Node root = null;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("1. Insert a Node\n");
            System.out.print("2. InOrder Traversal\n");
            System.out.print("3. PreOrder Traversal\n");
            System.out.print("4. PostOrder Traversal\n");
            System.out.print("5. Delete Leaf Node\n");
            System.out.print("6. Search a Node\n");

            System.out.print("9. Exit\n");
            int input = sc.nextInt();
            if (input == 1) {
                System.out.print("Enter Node Value ");
                int nodeValue = sc.nextInt();
                if (root == null) {
                    root = insertNewNode(root, nodeValue);
                } else {
                    insertNewNode(root, nodeValue);
                }
            }
            else if (input == 2)
                printInOrderTree(root);
            else if (input == 3)
                printPreOrderTree(root);
            else if (input == 4)
                printPostOrderTree(root);
            else if (input == 5) {
                Node deletedNode = deleteLeafNode(root);
                System.out.print("Deleted Leaf Node = " + deletedNode.data);
            }
            else if (input == 6) {
                System.out.print("Enter Key Value To Search ");
                int key = sc.nextInt();
                Node searchedNode = searchNode(root, key);
                if (searchedNode.data == key)
                    System.out.print("Key is present in the tree");
                else System.out.print("Key is NOT present in the tree");
            }
            else if (input == 9)
                break;
        }
    }

}
