public class BuildBST {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Insert a value in BST
    public static Node insert(Node root, int value) {
        // if tree is empty, create new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // insert in left subtree
        if (root.data > value) {
            root.left = insert(root.left, value);
        } 
        // insert in right subtree
        else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Inorder traversal (prints BST in sorted order)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search a key in BST
    // Time Complexity: O(H)
    public static boolean search(Node root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;

        if (root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Delete a node from BST
    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } 
        else if (root.data > val) {
            root.left = delete(root.left, val);
        } 
        else { // node found

            // Case 1: Leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Single child
            if (root.left == null) {
                return root.right;
            } 
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    // Find inorder successor (smallest in right subtree)
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {

        /*
            Insert order: 8, 5, 3, 1, 4, 6, 10, 11, 14

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

        // inorder traversal
        inorder(root);
        System.out.println();

        int val = 1; // delete leaf node
        delete(root, val);

        inorder(root);
        System.out.println();
    }
}
