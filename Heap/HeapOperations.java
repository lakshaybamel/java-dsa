
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
        public int peek() {
            return arr.get(0);
        }

        private void Heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                Heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // Step 1: Swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2: Delete Last
            arr.remove(arr.size() - 1);

            // Step 3: Heapify
            Heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(5);
        h.add(3);
        h.add(8);
        h.add(1);

        // h.printHeap(); // Min Heap
        // h.peek(); // Print Peek

        while(!h.isEmpty()) { // Heap Sort
            System.out.println(h.peek());
            h.remove();
        }
    }
}
