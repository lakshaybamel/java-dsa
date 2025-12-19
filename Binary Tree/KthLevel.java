import java.util.*;

public class KthLevel {

    // Binary Tree Node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Print all nodes at kth level
    public static void kLevel(Node root, int level, int k) {
        if (root == null) {
            return; // base case
        }

        // if current level is k, print node
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        // go to next level
        kLevel(root.left, level + 1, k);
        kLevel(root.right, level + 1, k);
    }

    public static void main(String[] args) {

        /*
                        1
                      /   \
                     2     3
                    / \   / \
                   4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 3; // level to print
        kLevel(root, 1, k); // start from level 1 (root)
    }
}
