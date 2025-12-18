public class SubtreeOfTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Check if two trees are identical
    public static boolean isIdentical(Node node, Node subRoot) {
        // both null → identical
        if (node == null && subRoot == null) {
            return true;
        }

        // one null or data mismatch → not identical
        if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        // check left and right subtree
        return isIdentical(node.left, subRoot.left) &&
               isIdentical(node.right, subRoot.right);
    }

    // Check if subRoot is subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        // if data matches, check identical
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // check in left or right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {

        /*
                Main Tree:
                        1
                      /   \
                     2     3
                    / \     \
                   4   5     6

                Sub Tree:
                        2
                      /   \
                     4     5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}
