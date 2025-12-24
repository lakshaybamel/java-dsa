public class SortedArrayToBalancedBST {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Create balanced BST from sorted array
    public static Node createBST(int arr[], int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // middle element becomes root
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        // recursively build left and right subtrees
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] arr = {3, 5, 6, 8, 10, 11, 12};

        /*
                Balanced BST:

                        8
                      /   \
                     5     11
                   /  \   /  \
                  3    6 10   12
        */

        Node root = createBST(arr, 0, arr.length - 1);

        System.out.print("Preorder traversal: ");
        preorder(root);
    }
}
