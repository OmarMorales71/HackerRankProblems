package omar.problems.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        System.out.println(arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        long maxVal=0L;
        long[] arr = new long[n+1];
        for(int[] query: queries){
            arr[query[0]-1] += query[2];
            arr[query[1]] -= query[2];
        }

        for(int i = 1; i<arr.length; i++){
            arr[i] += arr[i-1];
            maxVal = Math.max(maxVal, arr[i]);
        }
        return maxVal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }*/
}
