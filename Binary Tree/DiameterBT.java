public class DiameterBT {
    
    static class Node {
        int data; 
        Node left;
        Node right; 

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Height of binary tree
    public static int height(Node root) {
        if (root == null) {
            return 0; // no node
        }

        int lh = height(root.left);   // left subtree height
        int rh = height(root.right);  // right subtree height

        return Math.max(lh, rh) + 1;  // height = max + 1
    }

    // Diameter of binary tree (O(n^2))
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        // diameter of left subtree
        int leftDiam = diameter(root.left);

        // height of left subtree
        int leftHt = height(root.left);

        // diameter of right subtree
        int rightDiam = diameter(root.right);

        // height of right subtree
        int rightHt = height(root.right);

        // diameter passing through root
        int selfDiam = leftHt + rightHt + 1;

        // maximum of all three
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
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

        System.out.println("Diameter of tree: " + diameter(root));
    }
}
