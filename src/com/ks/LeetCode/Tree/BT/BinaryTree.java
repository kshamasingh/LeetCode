package com.ks.LeetCode.Tree.BT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    static class Node {
        int data;
        Node left, right;
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    static Node root;
    static Node root2;
    static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + ", ");
        inOrderTraversal(root.right);

    }

    static void insertUsingLevelOrderTraversal(Node temp, int data) {
        if (temp == null) {
            root = newNode(data);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();
            if (temp.left == null)
            {
                temp.left = newNode(data);
                break;
            } else queue.add(temp.left);
            if (temp.right == null)
            {
                temp.right = newNode(data);
                break;
            } else queue.add(temp.right);
        }
    }

    public class sNode{
        public Node l, r;
    };

    static Node mergeTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.data += t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        root = new Node();
        root2 = new Node();
        System.out.print("Insert Root in the empty tree: \n");
        Scanner scanner = new Scanner(System.in);
        int rootData = scanner.nextInt();
        root = newNode(rootData);

        while(true) {
            System.out.print("1. Insert In Tree-1 \n");
            System.out.print("2. Print Tree-1 \n");
            System.out.print("3. Insert Root In Tree-2 \n");
            System.out.print("4. Insert New Node In Tree-2 \n");
            System.out.print("5. Print Tree-2 \n");
            System.out.print("6. Merge Tree-1 & Tree-2 \n");
            System.out.print("9. Exit \n");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.print("Enter Node Value: ");
                    int nodeData = scanner.nextInt();
                    insertUsingLevelOrderTraversal(root, nodeData);
                    System.out.println("The new tree after insertion ");
                    inOrderTraversal(root);
                    System.out.print("\n");
                    break;
                case 2:
                    inOrderTraversal(root);
                    System.out.print("\n");
                    break;
                case 3:
                    System.out.print("Insert Root in the empty tree: \n");
                    Scanner scanner2 = new Scanner(System.in);
                    int rootData2 = scanner2.nextInt();
                    root2 = newNode(rootData2);
                    break;
                case 4:
                    System.out.print("Enter Node Value: ");
                    int nodeData2 = scanner.nextInt();
                    insertUsingLevelOrderTraversal(root2, nodeData2);
                    System.out.println("The new tree after insertion ");
                    inOrderTraversal(root2);
                    System.out.print("\n");
                    break;
                case 5:
                    inOrderTraversal(root2);
                    System.out.print("\n");
                    break;
                case 6:
                    Node mergedTree = mergeTrees(root, root2);
                    System.out.println("Merged Tree: ");
                    inOrderTraversal(mergedTree);
                    System.out.print("\n");
                    break;
            }
            if (input == 9)
                break;
        }

    }
}
