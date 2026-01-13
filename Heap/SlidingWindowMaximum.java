
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    // Pair stores value and its index
    static class Pair implements Comparable<Pair> {

        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        // Max Heap based on value
        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val; // descending order
        }
    }

    public static void main(String[] args) { // O(n log k)

        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3; // window size

        int result[] = new int[arr.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Process first window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        result[0] = pq.peek().val;

        // Process remaining windows
        for (int i = k; i < arr.length; i++) {

            // remove elements outside current window
            while (!pq.isEmpty() && pq.peek().idx <= i - k) {
                pq.remove();
            }

            // add current element
            pq.add(new Pair(arr[i], i));

            // max of current window
            result[i - k + 1] = pq.peek().val;
        }

        // print result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
