package omar.problems.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                int current = 0;
                for(int k= j; k <j+3; k++){
                    current+=arr[i][k]+arr[i+2][k];
                }
                current+=arr[i+1][j+1];
                ans=Math.max(ans, current);
            }
        }

        return ans;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
