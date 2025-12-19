import java.util.*;

public class TopViewOfTree {

    // Binary Tree Node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Helper class: stores node with its horizontal distance
    static class Info {
        Node node;
        int horizontalDist;

        public Info(Node node, int horizontalDist) {
            this.node = node;
            this.horizontalDist = horizontalDist;
        }
    }

    public static void topView(Node root) {
        // Level order traversal (BFS)
        Queue<Info> q = new LinkedList<>();

        // Stores first node for each horizontal distance
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0; // track horizontal distance range

        // start with root at horizontal distance 0
        q.add(new Info(root, 0));
        q.add(null); // level separator

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                // end of one level
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                // store first node for this horizontal distance
                if (!map.containsKey(curr.horizontalDist)) {
                    map.put(curr.horizontalDist, curr.node);
                }

                // left child → horizontal distance - 1
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horizontalDist - 1));
                    min = Math.min(min, curr.horizontalDist - 1);
                }

                // right child → horizontal distance + 1
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horizontalDist + 1));
                    max = Math.max(max, curr.horizontalDist + 1);
                }
            }
        }

        // print top view from leftmost to rightmost
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /*
                        1
                      /   \
                     2     3
                    / \   / \
                   4   5 6   7

            Top View: 4 2 1 3 7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topView(root);
    }
}
