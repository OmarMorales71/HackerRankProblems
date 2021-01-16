package omar.problems.sorting;

public class CountingInversions {

    public static void main(String[] args) {

        System.out.println(countInversions(new int[]{7, 5, 3, 1}));
    }

    // Complete the countInversions function below.
    static long swaps = 0;

    static long countInversions(int[] arr) {
        swaps = 0;
        mergeSort(arr);
        return swaps;
    }

    private static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n < 2)
            return;

        int mid = n / 2;
        int nLeft = mid;
        int nRight = n - mid;

        int[] L = new int[nLeft];
        int[] R = new int[nRight];

        for (int i = 0; i < mid; i++) {
            L[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            R[i - mid] = arr[i];
        }
        mergeSort(L);
        mergeSort(R);
        merge(arr, L, R);
    }

    private static void merge(int[] arr, int[] l, int[] r) {
        int i = 0, leftPointer = 0, rightPointer = 0;
        while (leftPointer < l.length && rightPointer < r.length) {
            if (l[leftPointer] <= r[rightPointer]) {
                arr[i] = l[leftPointer];
                leftPointer++;
            } else {
                arr[i] = r[rightPointer];
                rightPointer++;
                swaps+=l.length-leftPointer;
            }
            i++;
        }

        while (leftPointer < l.length) {
            arr[i] = l[leftPointer];
            leftPointer++;
            i++;
        }
        while (rightPointer < r.length) {
            arr[i] = r[rightPointer];
            rightPointer++;
            i++;
        }
    }


}
