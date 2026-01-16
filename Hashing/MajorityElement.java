
import java.util.HashMap;

public class MajorityElement {

    public static void main(String[] args) {

        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};

        // HashMap to store frequency of each element
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Count frequency of elements
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        // Print elements occurring more than n/3 times
        for (int key : hm.keySet()) {
            if (hm.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }
}
