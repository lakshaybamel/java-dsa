public class PrintInRange {

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

    // Print all nodes whose value lies in [k1, k2]
    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        // current node is in range
        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);   // check left
            System.out.print(root.data + " "); // print root
            printRange(root.right, k1, k2);  // check right
        }
        // current node < k1 → skip left subtree
        else if (root.data < k1) {
            printRange(root.right, k1, k2);
        }
        // current node > k2 → skip right subtree
        else {
            printRange(root.left, k1, k2);
        }
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

        // print nodes between 9 and 12
        printRange(root, 9, 12);
    }
}
