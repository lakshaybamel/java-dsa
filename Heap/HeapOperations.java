import java.util.*;

public class HeapOperations {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Insert into Min Heap
        public void add(int data) { // O(log n)
            // Step 1: add at last index
            arr.add(data);

            int x = arr.size() - 1;      // child index

            // Step 2: fix heap property
            while (x > 0) {
                int parent = (x - 1) / 2;

                // if heap property satisfied, stop
                if (arr.get(x) >= arr.get(parent)) {
                    break;
                }

                // swap child and parent
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);

                x = parent; // move up
            }
        }

        // Print heap
        public void printHeap() {
            System.out.println(arr);
        }

        // Print Peek
        public void peek() {
            System.out.println("Peek: " + arr.get(0));
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(5);
        h.add(3);
        h.add(8);
        h.add(1);

        h.printHeap(); // Min Heap
        h.peek(); // Print Peek
    }
}
