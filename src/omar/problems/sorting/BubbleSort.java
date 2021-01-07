package omar.problems.sorting;

import java.util.Scanner;

public class BubbleSort {


    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        boolean isReady = false;
        int swaps = 0;
        while(!isReady){
            isReady=true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1, a);
                    swaps++;
                    isReady=false;
                }
            }
        }
        System.out.println("Array is sorted in "+swaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);
    }

    static void swap(int i, int j, int[] arr){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}
