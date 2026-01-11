import java.util.PriorityQueue;

public class PriorityQueueUsingJCF {

    public static void main(String[] args) {

        // PriorityQueue (Min-Heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3); // O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        // elements come out in ascending order
        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove();                   // O(log n)
        }
    }
}
