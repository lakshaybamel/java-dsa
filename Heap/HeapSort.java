
public class HeapSort {

    // Heapify subtree rooted at index i
    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        // check left child
        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        // check right child
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        // if root is not largest
        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // heapify affected subtree
            heapify(arr, maxIdx, size);
        }
    }

    // Heap Sort
    public static void heapSort(int arr[]) {

        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // swap root (max) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify reduced heap
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3};

        heapSort(arr);

        // print sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
