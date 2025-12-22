public class SearchBST {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Insert a value into BST
    public static Node insert(Node root, int value) {
        // empty tree
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

    // Search key in BST
    // Time Complexity: O(H)
    public static boolean search(Node root, int key) {
        if (root == null) return false; // key not found

        if (root.data == key) return true; // key found

        // search in left or right subtree
        if (root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void main(String[] args) {

        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // build BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        int key = 7;

        if (search(root, key))
            System.out.println("Found!");
        else
            System.out.println("Not Found!");
    }
}
