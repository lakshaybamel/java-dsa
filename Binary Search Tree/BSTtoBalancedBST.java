import java.util.*;

public class BSTtoBalancedBST {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Create balanced BST from sorted inorder list
    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // choose middle element as root
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));

        // build left and right subtrees
        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);

        return root;
    }

    // Store inorder traversal of BST
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;

        getInorder(root.left, inorder);
        inorder.add(root.data);      // add current node
        getInorder(root.right, inorder);
    }

    // Convert unbalanced BST to balanced BST
    public static Node balanceBST(Node root) {
        // Step 1: get inorder traversal (sorted)
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        // Step 2: create balanced BST from sorted inorder
        return createBST(inorder, 0, inorder.size() - 1);
    }

    // Preorder traversal (for checking structure)
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        /*
            Given Unbalanced BST:

                    8
                  /   \
                 6     10
                /        \
               5          11
              /             \
             3               12
        */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
            Expected Balanced BST:

                        8
                      /   \
                     5     11
                   /  \   /  \
                  3    6 10   12
        */

        root = balanceBST(root);

        System.out.print("Preorder traversal: ");
        preorder(root);
    }
}
