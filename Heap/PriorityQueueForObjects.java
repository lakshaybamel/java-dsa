import java.util.PriorityQueue;

public class PriorityQueueForObjects {

    // Custom object
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // defines priority (min rank = high priority)
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {

        // Min-Heap based on rank
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 5));
        pq.add(new Student("B", 2));
        pq.add(new Student("D", 8));
        pq.add(new Student("C", 1));

        // students removed in increasing rank order
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
