import java.util.*;

public class RootToLeafPath {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Insert value into BST
    public static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (root.data > value) {
            root.left = insert(root.left, value);   // go left
        } else {
            root.right = insert(root.right, value); // go right
        }

        return root;
    }

    // Print one root-to-leaf path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("null");
    }

    // Find and print all root-to-leaf paths
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        // add current node to path
        path.add(root.data);

        // if leaf node, print path
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        // go to left and right subtree
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        // backtracking: remove current node
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        /*
            BST:
                    8
                  /   \
                 5     10
                / \      \
               3   6      11
              / \           \
             1   4           14
        */

        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // build BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // print all root-to-leaf paths
        printRoot2Leaf(root, new ArrayList<Integer>());
    }
}
