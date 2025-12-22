public class DeleteBST {

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

    // Inorder traversal (prints sorted order)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Delete node from BST
    public static Node delete(Node root, int val) {

        if (root.data < val) {
            root.right = delete(root.right, val);   // search in right
        } 
        else if (root.data > val) {
            root.left = delete(root.left, val);     // search in left
        } 
        else { // node found

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } 
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node IS = findInorderSuccessor(root.right); // smallest in right subtree
            root.data = IS.data;                        // replace value
            root.right = delete(root.right, IS.data);  // delete successor
        }
        return root;
    }

    // Find inorder successor (minimum in right subtree)
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
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

        inorder(root);
        System.out.println();

        int val = 1; // delete leaf node
        delete(root, val);

        inorder(root);
        System.out.println();
    }
}
