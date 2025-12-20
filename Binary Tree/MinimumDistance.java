import java.util.*;

public class MinimumDistance {

    // Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    // Find LCA
    public static Node lca(Node root, int n1, int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if (rightLca == null) return leftLca;
        if (leftLca == null) return rightLca;

        return root;
    }

    // Find distance from root to node n
    public static int lcaDist(Node root, int n) {
        if (root == null) return -1;

        if (root.data == n) return 0; // node found

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        // node not found in both subtrees
        if (leftDist == -1 && rightDist == -1) return -1;

        // return distance + 1
        if (leftDist == -1) return rightDist + 1;
        else return leftDist + 1;
    }

    // Minimum distance between n1 and n2
    public static int minDist(Node root, int n1, int n2) {
        Node lcaNode = lca(root, n1, n2); //    find LCA

        int dist1 = lcaDist(lcaNode, n1); // distance from LCA to n1
        int dist2 = lcaDist(lcaNode, n2); // distance from LCA to n2
    
        return dist1 + dist2; // total distance
    }

    public static void main(String[] args) {

        /*
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

        int n1 = 4, n2 = 7;
        System.out.println(minDist(root, n1, n2));

    }
}
