
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapUse {

    public static void main(String[] args) {

        // LinkedHashMap maintains insertion order
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);

        // Output in insertion order
        System.out.println(lhm);

        // HashMap does NOT maintain order
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        // Output order may vary
        System.out.println(hm);
    }
}
