public class HeightBT {
    
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

    // Function to find height of binary tree
    public static int height(Node root) {
        if (root == null) {
            return 0; // empty tree has height 0
        }

        // height of left subtree
        int lh = height(root.left);

        // height of right subtree
        int rh = height(root.right);

        // height = max(left, right) + 1 (for current node)
        return Math.max(lh, rh) + 1;
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

        System.out.println("Height of Binary Tree: " + height(root));
    }
}
