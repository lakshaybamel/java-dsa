
import java.util.HashMap;

public class HashMapOperations {

    public static void main(String[] args) {

        // Create HashMap (key -> value)
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert (put) → O(1)
        hm.put("India", 100);
        hm.put("China", 110);
        hm.put("US", 50);

        // Print HashMap
        System.out.println(hm);

        // Get value by key → O(1)
        System.out.println("India Population: " + hm.get("India")); // 100
        System.out.println(hm.get("UK")); // null (key not present)

        // Check key exists → O(1)
        System.out.println(hm.containsKey("India")); // true
        System.out.println(hm.containsKey("UK"));    // false

        // Remove key → O(1)
        System.out.println(hm.remove("China")); // 110
        System.out.println(hm.remove("UK"));    // null

        // Size of HashMap
        System.out.println(hm.size());

        // Check empty
        System.out.println(hm.isEmpty());

        // Remove all entries
        hm.clear();
    }
}
