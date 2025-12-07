package Queue;

public class UsingLL {
    
    // Node structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue structure with front & rear pointers
    static class Queue {
        static Node front = null;
        static Node rear = null;

        // check empty
        public static boolean isEmpty() {
            return front == null;
        }

        // add → O(1)
        public static void add(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {        // first element
                front = rear = newNode;
                return;
            }

            rear.next = newNode;    // attach new node at end
            rear = newNode;         // move rear
        }

        // remove → O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }

            int val = front.data;   // value to remove
            front = front.next;     // move front

            if (front == null) {    // if queue becomes empty
                rear = null;
            }

            return val;
        }

        // peek → O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return front.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove()); // 1
        System.out.println(q.peek());   // 2

        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
