import java.util.*;

public class MergeTwoBSTs {

    // BST Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Create balanced BST from sorted list
    public static Node createBST(ArrayList<Integer> finalArr, int start, int end) {
        if (start > end) {
            return null; // base case
        }

        int mid = (start + end) / 2;
        Node root = new Node(finalArr.get(mid));

        // build left and right subtrees
        root.left = createBST(finalArr, start, mid - 1);
        root.right = createBST(finalArr, mid + 1, end);

        return root;
    }

    // Store inorder traversal of BST
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;

        getInorder(root.left, inorder);
        inorder.add(root.data);      // add node
        getInorder(root.right, inorder);
    }

    // Merge two BSTs into one balanced BST
    public static Node mergeBSTs(Node root1, Node root2) {

        // Step 1: get inorder of first BST
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // Step 2: get inorder of second BST
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 3: merge two sorted lists
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i++));
            } else {
                finalArr.add(arr2.get(j++));
            }
        }

        // remaining elements
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i++));
        }
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j++));
        }

        // Step 4: build balanced BST from merged sorted list
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    // Preorder traversal (to verify tree)
    public static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        /*
            BST 1:
                2
               / \
              1   4

            BST 2:
                9
               / \
              3  12
        */

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);

        System.out.print("Preorder traversal: ");
        preorder(root);
    }
}
