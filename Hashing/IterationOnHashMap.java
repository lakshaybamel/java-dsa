
import java.util.HashMap;
import java.util.Set;

public class IterationOnHashMap {

    public static void main(String[] args) {

        // Create HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        // Add key-value pairs
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        // Get all keys from HashMap
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        // Iterate over keys
        for (String k : keys) {
            System.out.println("Key: " + k + ", Value: " + hm.get(k));
        }
    }
}
