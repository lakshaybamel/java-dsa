public class DiameterBTOptimized {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    // O(n) diameter calculation
    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info left = diameter(root.left);
        Info right = diameter(root.right);

        int height = Math.max(left.ht, right.ht) + 1;
        int selfDiam = left.ht + right.ht + 1;
        int diam = Math.max(selfDiam, Math.max(left.diam, right.diam));

        return new Info(diam, height);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Diameter: " + diameter(root).diam);
    }
}
