package Queue;
import java.util.LinkedList;
import java.util.Queue;

public class UsingJFC {
    public static void main(String[] args) {

        // Queue interface implemented by LinkedList
        Queue<Integer> q = new LinkedList<>();

        // add elements → O(1)
        q.add(1);
        q.add(2);
        q.add(3);

        // run until queue becomes empty
        while (!q.isEmpty()) {
            System.out.println(q.peek()); // shows front element
            q.remove();                   // removes front element
        }
    }
}
