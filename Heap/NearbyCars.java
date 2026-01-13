import java.util.PriorityQueue;

public class NearbyCars {

    // Represents a car point
    static class Point implements Comparable<Point> {

        int x, y;        // coordinates
        int distSq;      // distance squared from origin
        int idx;         // car index

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        // Min-Heap based on distance
        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {

        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        // Min Heap (nearest car at top)
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // Step 1: add all cars to PQ
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        // Step 2: remove k nearest cars
        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }
}
