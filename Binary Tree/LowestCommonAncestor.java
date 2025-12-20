import java.util.*;

public class LowestCommonAncestor {

    // Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // APPROACH 1: Using Paths

    // Find path from root to given node
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root); // add current node

        // target found
        if (root.data == n) {
            return true;
        }

        // search in left or right subtree
        if (getPath(root.left, n, path) ||
            getPath(root.right, n, path)) {
            return true;
        }

        // backtrack if not found
        path.remove(path.size() - 1);
        return false;
    }

    // Find LCA using paths
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // store paths from root to n1 and n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;

        // find last common node
        while (i < path1.size() && i < path2.size()) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
            i++;
        }

        // last common ancestor
        return path1.get(i - 1);
    }

    // APPROACH 2: Optimized Recursive
    public static Node lca2(Node root, int n1, int n2) {
        // base case
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // find LCA in left and right subtree
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // if one side is null, return the other
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        // both sides returned non-null → current node is LCA
        return root;
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

        Node ans = lca2(root, n1, n2);
        System.out.println("LCA: " + ans.data);
    }
}
