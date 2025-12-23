public class ValidateBST {

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

    // Check if tree is a valid BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) return true; // empty tree is valid

        // node must be greater than min
        if (min != null && root.data <= min.data) {
            return false;
        }
        // node must be smaller than max
        else if (max != null && root.data >= max.data) {
            return false;
        }

        // validate left and right subtrees
        return isValidBST(root.left, min, root) &&
               isValidBST(root.right, root, max);
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

        if(isValidBST(root, null, null)) System.out.println("Valid BST!");
        else System.out.println("Invalid BST!!");
    }
}
