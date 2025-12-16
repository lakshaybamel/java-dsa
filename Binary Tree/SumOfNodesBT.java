public class SumOfNodesBT {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to find sum of all nodes
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0; // no node → sum = 0
        }

        // sum = left subtree + right subtree + root value
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data;
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

        System.out.println("Sum of nodes: " + sumNodes(root));
    }
}
