
import java.util.HashMap;
import java.util.TreeMap;

public class TreeMapUse {

    public static void main(String[] args) {

        // TreeMap maintains keys in sorted order (ascending)
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);

        // Output in sorted order of keys
        System.out.println(tm);

        // HashMap does not maintain any order
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);
    }
}
