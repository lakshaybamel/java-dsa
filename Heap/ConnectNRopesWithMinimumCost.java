
import java.util.PriorityQueue;

public class ConnectNRopesWithMinimumCost {

    public static void main(String[] args) {

        int ropes[] = {2, 3, 3, 4, 6};

        // Min Heap to always pick smallest ropes
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all ropes to heap
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;

        // keep connecting two smallest ropes
        while (pq.size() > 1) {
            int min1 = pq.remove();   // smallest rope
            int min2 = pq.remove();   // second smallest

            int sum = min1 + min2;
            cost += sum;              // add cost

            pq.add(sum);              // push back combined rope
        }

        System.out.println("Cost of connecting n ropes: " + cost);
    }
}
