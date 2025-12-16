import java.util.*;

public class CreateBinaryTree {
    
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

    static class BinaryTree {
        static int idx = -1; // global index to traverse array

        // Build tree using preorder (node, left, right)
        public static Node buildTree(int nodes[]) {
            idx++;

            // -1 means null node
            if(nodes[idx] == -1) 
                return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);  // build left subtree
            newNode.right = buildTree(nodes); // build right subtree

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return; // empty tree
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // level separator

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println(); // move to next line for new level

                if (q.isEmpty()) {
                    break; // traversal finished
                } else {
                    q.add(null); // add separator for next level
                }

            } else {
                System.out.print(currNode.data + " ");

                // add left child
                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                // add right child
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nodes = {
            1, 2, 4, -1, -1, 5, -1, -1,
            3, -1, 6, -1, -1
        };
        CreateBinaryTree tree = new CreateBinaryTree();
        Node root = BinaryTree.buildTree(nodes);

        tree.preOrder(root);
        System.out.println();
        tree.inOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();

        tree.levelOrder(root);
    }
}
