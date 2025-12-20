import java.util.*;

public class KthAncestor {

    // Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Find kth ancestor of node n
    public static int kAncestor(Node root, int n, int k) {
        if (root == null) return -1;     // base case
        if (root.data == n) return 0;    // target node found

        // search in left and right subtree
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);

        // node not found in both subtrees
        if (leftDist == -1 && rightDist == -1) return -1;

        // take the valid distance
        int max = Math.max(leftDist, rightDist);

        // if current node is kth ancestor
        if (max + 1 == k) {
            System.out.println(root.data);
        }

        // return distance from target
        return max + 1;
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

        int n = 5, k = 1;

        kAncestor(root, n, k);
    }
}
