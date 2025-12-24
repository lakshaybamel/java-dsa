public class MirrorBST {

    // Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Create mirror of binary search tree
    // Time Complexity: O(n)
    public static Node createMirror(Node root) {
        if (root == null) {
            return null; // base case
        }

        // mirror left and right subtrees
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        // swap children
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        /*
                Original Tree:
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

        System.out.print("Inorder before mirror: ");
        inorder(root);
        System.out.println();

        createMirror(root);

        System.out.print("Inorder after mirror: ");
        inorder(root);
        System.out.println();
    }
}
