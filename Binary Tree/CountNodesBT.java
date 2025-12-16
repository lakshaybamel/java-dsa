public class CountNodesBT {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to count total nodes in binary tree
    public static int countNodes(Node root) {
        if (root == null) {
            return 0; // no node
        }

        // count = left subtree + right subtree + root
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {

        /*
                        1
                      /   \
                     2     3
                    / \     \
                   4   5     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        System.out.println("Total nodes: " + countNodes(root));
    }
}
